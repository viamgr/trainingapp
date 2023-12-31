package com.training.app.trainingapp.main.view.signup

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.view_model.signup.SignUpViewModel
import com.training.app.trainingapp.utils.Screen
import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.repository.SignUpRepository
import com.trainning.app.domain.usecase.SignUpViewUseCase

@Composable
fun SignUpScreen(
        navController: NavController,
        signUpViewModel: SignUpViewModel
) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            val pageState = signUpViewModel.pageState.collectAsState().value
            if (pageState.pageState != PageState.LOADING) {
                SignUpContent(pageState.email,
                              pageState.emailValidate,
                              onEmailChanged = {
                                  signUpViewModel.onEmailChanged(it)
                              },
                              onSubmitButtonClick = {
                                  signUpViewModel.onSubmitButtonClicked()
                              },
                              onForgetPasswordClick = {
                                  navController.navigate(Screen.ForgetPassword.name)
                              })
            } else {
                CircularProgressIndicator(modifier = Modifier.requiredSize(48.dp, 48.dp))
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(rememberNavController(), SignUpViewModel(SignUpViewUseCase(object : SignUpRepository {
        override suspend fun signup(email: String): SignUpResponse {
            return SignUpResponse(true)
        }
    })))
}