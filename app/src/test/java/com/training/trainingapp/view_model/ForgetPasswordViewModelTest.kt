package com.training.trainingapp.view_model

import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordEffect
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordViewModel
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ForgetPasswordViewModelTest {

    @MockK
    private lateinit var forgetPasswordUseCase: ForgetPasswordUseCase

    @MockK
    private lateinit var forgetPasswordRepository: ForgetPasswordRepository

    @InjectMockKs
    private lateinit var viewModel: ForgetPasswordViewModel

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        forgetPasswordRepository = object : ForgetPasswordRepository {
            override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
                return ForgetPasswordResponse(true)
            }
        }
        forgetPasswordUseCase = spyk(ForgetPasswordUseCase(forgetPasswordRepository))
        viewModel = spyk(ForgetPasswordViewModel(forgetPasswordUseCase))
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
        assertEquals(true, viewModel.state.value.emailValidateState)
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
    fun sendEmailForPasswordRecovery_should_emit_effect() {
        val email = "paria.m7616@gmail.com"
        val successResponse = ForgetPasswordResponse(true)
        coEvery {
            forgetPasswordUseCase.invoke(email)
        } returns successResponse
        viewModel.onEmailChanged(email)
        viewModel.validateEmail()
        viewModel.sendEmailForPasswordRecovery()
        testDispatcher.scheduler.advanceUntilIdle()
        val effect = viewModel.efectFlow.replayCache.first()
        assertTrue(effect is ForgetPasswordEffect.ShowSnackbar)
    }

    @Test
    fun sendEmailForPasswordRecovery_should_update_state_and_emit_effect() {
        // Given
        val email = "paria.m7616@gmail.com"
        viewModel.onEmailChanged(email)
        viewModel.validateEmail()
        val successResponse = ForgetPasswordResponse(true)
        coEvery { forgetPasswordUseCase.invoke(any()) } returns successResponse
        viewModel.sendEmailForPasswordRecovery()
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(viewModel.state.value.forgetPasswordResponse)
        assertTrue(viewModel.state.value.isDisplayedSnackbar)

        val effectList = viewModel.efectFlow.replayCache
        assertTrue(effectList.isNotEmpty())

        val effect = effectList.firstOrNull()
        assertNotNull(effect)
        assertTrue(effect is ForgetPasswordEffect.ShowSnackbar)
        assertEquals(
            "Forget Password Response:${successResponse}",
            (effect as ForgetPasswordEffect.ShowSnackbar).message
        )
    }

    @After
    fun close() {
        Dispatchers.shutdown()
    }
}