package com.training.app.trainingapp.main.view_model

import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.state.register.RegisterPageState
import com.trainning.app.domain.usecase.RegisterViewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerViewUseCase: RegisterViewUseCase) : ViewModel() {

    private val _pageState = MutableStateFlow(RegisterPageState(PageState.idle, "", "", true))
    val pageState: StateFlow<RegisterPageState> = _pageState


    fun validateEmail() {
        _pageState.update { _pageState.value.copy(emailValidate = PatternsCompat.EMAIL_ADDRESS.matcher(_pageState.value.email).matches()) }
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
            _pageState.update { (_pageState.value.copy(pageState = PageState.loading)) }

            val response = registerViewUseCase.invoke(email = email)
            val pageState = if (response.isSuccess) PageState.success else PageState.failed

            _pageState.update { _pageState.value.copy(pageState = pageState) }
        }
    }

}