package com.training.app.trainingapp.main.state.register

import com.training.app.trainingapp.main.state.base.PageState

data class RegisterPageState(
        val pageState: PageState,
        val message: String,
        val email: String,
        val emailValidate: Boolean
)