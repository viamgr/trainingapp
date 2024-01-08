package com.training.app.trainingapp.main.state.forgetpassword

data class ForgetPasswordState(
    val email: String,
    val emailValidateState: Boolean,
    val forgetPasswordResponse: Boolean,
    val isDisplayedSnackbar: Boolean
) {
    constructor() : this(
        email = "",
        emailValidateState = false,
        forgetPasswordResponse = false,
        isDisplayedSnackbar = false
    )
}