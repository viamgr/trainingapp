package com.training.trainingapp.view_model

import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordEffect
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordEvent
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordViewModel
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
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
    }

    @Test
    fun onEmailChanged_should_update_email_in_state() {
        val email = "test@example.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        assertEquals(email, viewModel.state.value.email)
    }

    @Test
    fun validateEmail_should_update_email_validation_state_in_state() {
        val email = "test@example.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        assertEquals(true, viewModel.state.value.emailValidateState)
    }

    @Test
    fun onSubmitButtonClicked_should_call_sendEmailForPasswordRecovery_when_email_is_valid() = runTest{
        val email = "paria.m7616@gmail.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
        assertTrue(viewModel.state.value.isDisplayedSnackbar)
    }

    @Test
    fun sendEmailForPasswordRecovery_should_emit_effect() = runTest{
        val email = "paria.m7616@gmail.com"
        val successResponse = ForgetPasswordResponse(true)
        coEvery {
            forgetPasswordUseCase.invoke(email)
        } returns successResponse
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
        val effect = viewModel.efectFlow.first()
        assertTrue(effect is ForgetPasswordEffect.ShowSnackbar)
    }

    @Test
    fun sendEmailForPasswordRecovery_should_update_state_and_emit_effect()= runTest{
        val email = "paria.m7616@gmail.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
        assertTrue( viewModel.state.value.forgetPasswordResponse)

        val showSnackBarEffect = viewModel.efectFlow.first()
        assertNotNull(showSnackBarEffect)
        assertTrue( showSnackBarEffect is ForgetPasswordEffect.ShowSnackbar)

        val response = viewModel.state.value.forgetPasswordResponse
        assertEquals(
            "$response",
            (showSnackBarEffect as ForgetPasswordEffect.ShowSnackbar).message
        )
    }
}