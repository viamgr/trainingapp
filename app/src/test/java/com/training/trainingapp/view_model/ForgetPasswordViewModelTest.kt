package com.training.trainingapp.view_model

import com.training.app.data.authorization.forgetpassword.dataprovider.ForgetPasswordDataProvider
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordEffect
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordViewModel
import com.training.app.data.authorization.forgetpassword.repo.ForgetPasswordRepositoryImpl
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ForgetPasswordViewModelTest {

    private lateinit var forgetPasswordUseCase: ForgetPasswordUseCase

    @Mock
    private lateinit var forgetPasswordRepository : ForgetPasswordRepository

    @Mock
    private lateinit var apiService: ForgetPasswordDataProvider // Replace with the actual service you use


    private lateinit var viewModel: ForgetPasswordViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        forgetPasswordRepository = ForgetPasswordRepositoryImpl(apiService)
        forgetPasswordUseCase = ForgetPasswordUseCase(forgetPasswordRepository)
        viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
    }

    @Test
    fun onEmailChanged_should_update_email_in_state() {
        val email = "test@example.com"
        viewModel.onEmailChanged(email)
        assertEquals(email, viewModel.state.value.email)
    }

    @Test
    fun validateEmail_should_update_email_validation_state_in_state() {
        viewModel.onEmailChanged("test@example.com")
        viewModel.validateEmail()
        assertEquals(false, viewModel.state.value.emailValidateState)
    }

    @Test
    fun onSubmitButtonClicked_should_call_sendEmailForPasswordRecovery_when_email_is_valid() {
        viewModel.onEmailChanged("test@example.com")
        viewModel.validateEmail()
        viewModel.onSubmitButtonClicked()
        verify(viewModel).sendEmailForPasswordRecovery()
    }

    @Test
    fun sendEmailForPasswordRecovery_should_update_email_validation_state_and_emit_effect() {
        val email = "test@example.com"
        val successResponse = ForgetPasswordResponse(true)
        runTest {
            `when`(forgetPasswordUseCase.invoke(email)).thenReturn(successResponse)
        }
        viewModel.sendEmailForPasswordRecovery()
        assertEquals(successResponse.isSuccess, viewModel.state.value.emailValidateState)
        val effect = viewModel.efectFlow.replayCache.first()
        assertTrue(effect is ForgetPasswordEffect.ShowSnackbar)
    }
}

