package com.training.app.trainingapp.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.training.app.trainingapp.main.view.navigation.MainApp
import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel
import com.training.app.trainingapp.main.viewmodel.signup.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()
    private val forgetPasswordViewModel: ForgetPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp(signUpViewModel, forgetPasswordViewModel)
        }
    }

}

