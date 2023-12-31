package com.training.app.trainingapp.main.view.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordScreen
import com.training.app.trainingapp.main.view.signup.SignUpScreen
import com.training.app.trainingapp.main.view_model.ForgetPasswordViewModel
import com.training.app.trainingapp.main.view_model.signup.SignUpViewModel
import com.training.app.trainingapp.utils.Screen

@Composable
fun MainApp(
        signUpViewModel: SignUpViewModel = viewModel(),
        forgetPasswordViewModel: ForgetPasswordViewModel = viewModel(),
        navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.Register.name) {
        composable(Screen.Register.name) {
            SignUpScreen(
                    navController = navController,
                    signUpViewModel = signUpViewModel
            )
        }
        composable(Screen.ForgetPassword.name) {
            ForgetPasswordScreen(
                    viewModel = forgetPasswordViewModel
            )
        }
    }
}