package com.training.app.trainingapp.main.view.forget_password

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.view_model.ForgetPasswordViewModel

@Composable
fun ForgetPasswordScreen(navController: NavController, viewModel: ForgetPasswordViewModel) {
    BackHandler {
        navController.popBackStack()
    }
    ForgetPasswordContent(
        userEmail = viewModel.userEmail.collectAsState().value,
        emailValidateState = viewModel.emailValidateState.collectAsState().value,
        onEmailChanged = {},
        onSubmitButtonClick = {})
}

@Preview
@Composable
fun ForgetPasswordScreenPreview() {
    ForgetPasswordScreen(rememberNavController(), ForgetPasswordViewModel())
}