package com.training.app.trainingapp.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.view.signup.SignUpPageView
import com.training.app.trainingapp.main.view_model.signup.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                val pageState = signUpViewModel.pageState.collectAsState().value
                if (pageState.pageState != PageState.LOADING) {
                    SignUpPageView(pageState.email,
                                   pageState.emailValidate,
                                   onEmailChanged = {
                                       signUpViewModel.onEmailChanged(it)
                                   },
                                   onSubmitButtonClick = {
                                       signUpViewModel.onSubmitButtonClicked()
                                   })
                } else {
                    CircularProgressIndicator(modifier = Modifier.requiredSize(48.dp, 48.dp))
                }
            }
        }
    }

}

