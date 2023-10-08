package com.training.app.trainingapp.main.view.forget_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun ForgetPasswordScreen(viewModel: ForgetPasswordViewModel) {
    ForgetPasswordContent(
        viewModel.userEmail.collectAsState().value,
        viewModel.emailValidateState.collectAsState().value,
        {},
        {})
}