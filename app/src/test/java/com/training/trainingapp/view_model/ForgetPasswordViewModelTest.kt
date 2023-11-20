package com.training.trainingapp.view_model

import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordEffect
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordViewModel
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ForgetPasswordViewModelTest {

    private lateinit var forgetPasswordUseCase: ForgetPasswordUseCase

    @Mock
    private lateinit var forgetPasswordRepository: ForgetPasswordRepository

    private lateinit var viewModel: ForgetPasswordViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        forgetPasswordUseCase = ForgetPasswordUseCase(forgetPasswordRepository)
        viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
        Dispatchers.setMain(testDispatcher)
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
        viewModel.onEmailChanged("paria.m616@gmail.com")
        viewModel.validateEmail()
        viewModel.onSubmitButtonClicked()
        // viewModel.sendEmailForPasswordRecovery()
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(viewModel.state.value.isDisplayedSnackbar)
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

    @After
    fun close() {
          Dispatchers.shutdown()
    }
}