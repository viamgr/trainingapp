package com.training.app.trainingapp.main.state.signup

import com.training.app.trainingapp.main.state.base.PageState

data class SignUpPageState(
        val pageState: PageState,
        val message: String,
        val email: String,
        val emailValidate: Boolean
)