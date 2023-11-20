package com.training.app.trainingapp.main.view.forget_password

import android.util.Log
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForgetPasswordViewModel @Inject constructor(private val forgetPasswordUseCase: ForgetPasswordUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(ForgetPasswordState())
    val state: StateFlow<ForgetPasswordState> = _state.asStateFlow()

    private val _efectFlow = MutableSharedFlow<ForgetPasswordEffect>()
    val efectFlow = _efectFlow.asSharedFlow()

    fun onEvent(event: ForgetPasswordEvent) {
        when (event) {
            is ForgetPasswordEvent.OnEmailChanged -> {
                onEmailChanged(event.email)
            }

            ForgetPasswordEvent.OnSubmitButtonClicked -> {
                onSubmitButtonClicked()
            }

            else -> {}
        }
    }

    fun validateEmail() {
        _state.update { mState ->
            mState.copy(emailValidateState = PatternsCompat.EMAIL_ADDRESS.matcher(_state.value.email).matches())
        }
    }

    fun onEmailChanged(email: String) {
        _state.update { mState ->
            mState.copy(email = email)
        }
    }

    fun onSubmitButtonClicked() {
        validateEmail()
        if (_state.value.emailValidateState) {
            sendEmailForPasswordRecovery()
        }
    }

     fun sendEmailForPasswordRecovery() {
        viewModelScope.launch {
          //  Log.d("ForgetPass", "sendEmailForPasswordRecovery: " )
            forgetPasswordUseCase.invoke(_state.value.email).let {
                _state.update { mState ->
                    mState.copy(forgetPasswordResponse = it.isSuccess, isDisplayedSnackbar = true)
                }
                _efectFlow.emit(
                    ForgetPasswordEffect.ShowSnackbar(
                        message = "Forget Password Response:" + it.isSuccess
                    )
                )
            }
        }
    }
}