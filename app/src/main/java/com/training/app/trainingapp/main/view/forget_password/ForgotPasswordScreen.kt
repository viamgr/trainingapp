package com.training.app.trainingapp.main.view.forget_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.training.app.trainingapp.main.view_model.ForgetPasswordViewModel

@Composable
fun ForgetPasswordScreen(viewModel: ForgetPasswordViewModel) {
    ForgetPasswordContent(
        userEmail = viewModel.userEmail.collectAsState().value,
        emailValidateState = viewModel.emailValidateState.collectAsState().value,
        onEmailChanged = {},
        onSubmitButtonClick = {})
}

@Preview
@Composable
fun ForgetPasswordScreenPreview() {
    ForgetPasswordScreen(ForgetPasswordViewModel())
}