package com.training.app.trainingapp.main.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.view.forgetpassword.ForgetPasswordScreen
import com.training.app.trainingapp.main.view.signup.SignUpScreen
import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel
import com.training.app.trainingapp.main.viewmodel.signup.SignUpViewModel
import com.training.app.trainingapp.utils.Screen

@Composable
fun MainApp(
    signUpViewModel: SignUpViewModel,
    forgetPasswordViewModel: ForgetPasswordViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.Register.name) {
        composable(Screen.Register.name) {
            SignUpScreen(
                navController = navController, signUpViewModel = signUpViewModel
            )
        }
        composable(Screen.ForgetPassword.name) {
            ForgetPasswordScreen(
                viewModel = forgetPasswordViewModel
            )
        }
    }
}