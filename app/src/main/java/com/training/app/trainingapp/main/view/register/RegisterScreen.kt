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
import com.training.app.trainingapp.main.view_model.RegisterViewModel
import com.training.app.trainingapp.utils.Screen

@Composable
fun RegisterScreen(navController:NavController ,registerViewModel:RegisterViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        val email = registerViewModel.userEmail.collectAsState().value
        val emailStatus = registerViewModel.emailValidateState.collectAsState().value
        RegisterContent(email,
            emailStatus,
            onEmailChanged = {
                registerViewModel.onEmailChanged(it)
            },
            onSubmitButtonClick = {
                registerViewModel.onSubmitButtonClicked()
            },
            onForgetPasswordClick = {
                navController.navigate(Screen.ForgetPassword.name)
            })
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController(), RegisterViewModel())
}