package com.training.app.trainingapp.main.view.forgetpassword

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.training.app.trainingapp.main.state.forgetpassword.ForgetPasswordState
import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ForgetPasswordScreen(viewModel: ForgetPasswordViewModel) {

    val context = LocalContext.current
    LaunchedEffect(context) {
        viewModel.efectFlow.collectLatest { event ->
            when (event) {
                is ForgetPasswordEffect.ShowSnackbar -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    val state: ForgetPasswordState by viewModel.state.collectAsState()

    ForgetPasswordContent(
        state = state,
        onEmailChanged = {
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(it))
        },
        onSubmitButtonClick = {
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
        }
    )
}

@Preview
@Composable
fun ForgetPasswordScreenPreview() {
    ForgetPasswordScreen(
        ForgetPasswordViewModel(ForgetPasswordUseCase(object :
            ForgetPasswordRepository {
            override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
                return ForgetPasswordResponse(true)
            }
        }))
    )
}