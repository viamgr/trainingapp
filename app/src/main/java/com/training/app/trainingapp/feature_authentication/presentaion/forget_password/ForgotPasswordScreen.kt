package com.training.app.trainingapp.feature_authentication.presentaion.forget_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ForgetPasswordScreen(viewModel: ForgetPasswordViewModel) {
    ForgetPasswordContent(
        viewModel.userEmail.collectAsState().value,
        viewModel.emailValidateState.collectAsState().value,
        {},
        {})
}

@Preview
@Composable
fun ForgetPasswordScreenPreview() {
    ForgetPasswordScreen(ForgetPasswordViewModel())
}