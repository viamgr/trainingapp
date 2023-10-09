package com.training.app.trainingapp.main.view_model

import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class RegisterViewModel: ViewModel() {

    private val _userEmail = MutableStateFlow("")
    val userEmail: StateFlow<String> = _userEmail


    private val _emailValidateState = MutableStateFlow(false)
    val emailValidateState: StateFlow<Boolean> = _emailValidateState

    fun validateEmail() {
        _emailValidateState.value = PatternsCompat.EMAIL_ADDRESS.matcher(_userEmail.value).matches()
    }

    fun onEmailChanged(email: String) {
        _userEmail.value = email
    }

    fun onSubmitButtonClicked() {
        validateEmail()
    }
}