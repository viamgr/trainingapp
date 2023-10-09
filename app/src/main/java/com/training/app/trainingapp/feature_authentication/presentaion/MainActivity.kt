package com.training.app.trainingapp.feature_authentication.presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.training.app.trainingapp.feature_authentication.presentaion.register.RegisterPageView
import com.training.app.trainingapp.feature_authentication.presentaion.register.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                val email = registerViewModel.userEmail.collectAsState().value
                val emailStatus = registerViewModel.emailValidateState.collectAsState().value
                RegisterPageView(email,
                    emailStatus,
                    onEmailChanged = {
                        registerViewModel.onEmailChanged(it)
                    },
                    onSubmitButtonClick = {
                        registerViewModel.onSubmitButtonClicked()
                    })
            }
        }
    }

}

