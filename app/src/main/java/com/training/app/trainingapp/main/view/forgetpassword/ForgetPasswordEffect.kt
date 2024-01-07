package com.training.app.trainingapp.main.view.forgetpassword

sealed class ForgetPasswordEffect {
    data class ShowSnackbar(val message: String) : ForgetPasswordEffect()
}