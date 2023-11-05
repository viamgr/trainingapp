package com.training.app.trainingapp.main.view.forget_password

data class ForgetPasswordState(
    val email: String,
    val emailValidateState: Boolean
) {
    constructor() : this(
        email = "",
        emailValidateState = false
    )
}