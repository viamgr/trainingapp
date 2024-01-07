package com.training.app.trainingapp.main.view.forgetpassword

sealed class ForgetPasswordEvent {

    data class OnEmailChanged(val email: String) : ForgetPasswordEvent()
    data object OnSubmitButtonClicked : ForgetPasswordEvent()

}