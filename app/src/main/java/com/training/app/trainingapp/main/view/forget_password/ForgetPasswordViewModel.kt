package com.training.app.trainingapp.main.view.forget_password

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

    private val _efectFlow = MutableSharedFlow<ForgetPasswordEffect>(1)
    val efectFlow = _efectFlow.asSharedFlow()

    fun onEvent(event: ForgetPasswordEvent) {
        when (event) {
            is ForgetPasswordEvent.OnEmailChanged -> {
                onEmailChanged(event.email)
            }

            ForgetPasswordEvent.OnSubmitButtonClicked -> {
                onSubmitButtonClicked()
            }
        }
    }

    private fun validateEmail() {
        _state.update { mState ->
            mState.copy(
                emailValidateState = PatternsCompat.EMAIL_ADDRESS.matcher(_state.value.email)
                    .matches()
            )
        }
    }

    private fun onEmailChanged(email: String) {
        _state.update { mState ->
            mState.copy(email = email)
        }
        validateEmail()
    }

    private fun onSubmitButtonClicked() {
        validateEmail()
        if (_state.value.emailValidateState) {
            sendEmailForPasswordRecovery()
        }
    }

    private fun sendEmailForPasswordRecovery() {
        viewModelScope.launch {
            forgetPasswordUseCase.invoke(_state.value.email).also {
                _state.update { mState ->
                    mState.copy(forgetPasswordResponse = it.isSuccess, isDisplayedSnackbar = true)
                }
                val message = if(it.isSuccess) "success" else "failed"
                _efectFlow.tryEmit(
                    ForgetPasswordEffect.ShowSnackbar(
                        message = message
                    )
                )
            }
        }
    }
}