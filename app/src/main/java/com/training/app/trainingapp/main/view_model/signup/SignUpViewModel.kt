package com.training.app.trainingapp.main.view_model.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.state.signup.SignUpPageState
import com.training.app.trainingapp.utils.RegexChecker
import com.trainning.app.domain.usecase.SignUpViewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val registerViewUseCase: SignUpViewUseCase) : ViewModel() {

    private val _pageState = MutableStateFlow(SignUpPageState(PageState.IDLE, "", "", true))
    val pageState: StateFlow<SignUpPageState> = _pageState


    private fun validateEmail() {
        _pageState.update { _pageState.value.copy(emailValidate = RegexChecker.isEmailCorrect(_pageState.value.email)) }
    }

    fun onEmailChanged(email: String) {
        _pageState.update { _pageState.value.copy(email = email) }
    }

    fun onSubmitButtonClicked() {
        validateEmail()
        if (_pageState.value.emailValidate) {
            registerEmail(_pageState.value.email)
        }
    }

    private fun registerEmail(email: String) {
        viewModelScope.launch {
            _pageState.update { (_pageState.value.copy(pageState = PageState.LOADING)) }

            val response = registerViewUseCase.invoke(email = email)
            val pageState = if (response.isSuccess) PageState.SUCCESS else PageState.FAILED

            _pageState.update { _pageState.value.copy(pageState = pageState) }
        }
    }

}