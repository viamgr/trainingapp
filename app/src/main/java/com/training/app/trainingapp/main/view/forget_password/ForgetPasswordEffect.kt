package com.training.app.trainingapp.main.view.forget_password

sealed class ForgetPasswordEffect {
    data class ShowSnackbar(val message: String): ForgetPasswordEffect()
}