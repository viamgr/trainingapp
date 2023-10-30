package com.training.app.trainingapp.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.view.register.RegisterScreen
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordScreen
import com.training.app.trainingapp.main.view_model.ForgetPasswordViewModel
import com.training.app.trainingapp.main.view_model.RegisterViewModel
import com.training.app.trainingapp.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()
    private val forgetPasswordViewModel: ForgetPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.Register.name) {
                composable(Screen.Register.name) {
                    RegisterScreen(
                        navController = navController,
                        registerViewModel = registerViewModel
                    )
                }
                composable(Screen.ForgetPassword.name) {
                    ForgetPasswordScreen(viewModel = forgetPasswordViewModel)
                }
            }
        }
    }
}