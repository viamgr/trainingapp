package com.training.app.trainingapp.main.view.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.view_model.SignUpViewModel
import com.training.app.trainingapp.utils.Screen

@Composable
fun SignUpScreen(navController:NavController, signUpViewModel:SignUpViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        val email = signUpViewModel.userEmail.collectAsState().value
        val emailStatus = signUpViewModel.emailValidateState.collectAsState().value
        SignUpContent(email,
            emailStatus,
            onEmailChanged = {
                signUpViewModel.onEmailChanged(it)
            },
            onSubmitButtonClick = {
                signUpViewModel.onSubmitButtonClicked()
            },
            onForgetPasswordClick = {
                navController.navigate(Screen.ForgetPassword.name)
            })
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    SignUpScreen(rememberNavController(), SignUpViewModel())
}