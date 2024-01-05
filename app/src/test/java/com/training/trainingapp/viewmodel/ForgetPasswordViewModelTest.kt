package com.training.trainingapp.viewmodel

import com.training.app.trainingapp.main.view.forgetpassword.ForgetPasswordEffect
import com.training.app.trainingapp.main.view.forgetpassword.ForgetPasswordEvent
import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import io.mockk.coEvery
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
class ForgetPasswordViewModelTest {

    private lateinit var viewModel: ForgetPasswordViewModel
    private var forgetPasswordUseCase = mockk<ForgetPasswordUseCase>(relaxUnitFun = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun givenEmail_WhenEmailChanged_ThenEmailStateShouldBeUpdate() = runTest {
        val email = "test@example.com"
        forgetPasswordUseCase = mockk(relaxed = true) {
            coEvery {
                forgetPasswordUseCase.invoke(any())
            } returns ForgetPasswordResponse(false)
        }
        viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        assertEquals(email, viewModel.state.value.email)
    }

    @Test
    fun givenCorrectEmail_WhenEmailChanged_ThenValidationShouldBeTrue() {
        val email = "test@example.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        assertTrue(viewModel.state.value.emailValidateState)
    }

    @Test
    fun givenWrongEmail_WhenEmailChanged_ThenValidationShouldBeFalse() {
        val email = "testexample.com"
        viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
        assertFalse(viewModel.state.value.emailValidateState)
    }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitButtonClicked_ThenForgetPasswordStateIsTrue() =
        runTest {
            val email = "paria.m7616@gmail.com"
            forgetPasswordUseCase = mockk {
                coEvery {
                    this@mockk.invoke(any())
                } returns ForgetPasswordResponse(true)
            }
            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            assertTrue(viewModel.state.value.forgetPasswordResponse)
        }

    @Test
    fun givenWrongEmail_WhenEmailChangedAndSubmitButtonClicked_ThenForgetPasswordStateIsFalse() =
        runTest {
            val email = "paria.m7616gmail.com"
            forgetPasswordUseCase = mockk {
                coEvery {
                    this@mockk.invoke(any())
                } returns ForgetPasswordResponse(false)
            }
            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            assertFalse(viewModel.state.value.forgetPasswordResponse)
        }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitButtonClicked_ThenSnackBarEffectShouldBeEmittWithTureMessage() =
        runTest {

            val email = "paria.m7616@gmail.com"
            forgetPasswordUseCase = mockk {
                coEvery {
                    this@mockk.invoke(any())
                } returns ForgetPasswordResponse(true)
            }
            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            assertTrue(viewModel.state.value.forgetPasswordResponse)

            val showSnackBarEffect = viewModel.efectFlow.first()
            assertNotNull(showSnackBarEffect)
            assertTrue(showSnackBarEffect is ForgetPasswordEffect.ShowSnackbar)

            assertEquals(
                "success",
                (showSnackBarEffect as ForgetPasswordEffect.ShowSnackbar).message
            )
        }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitButtonClicked_ThenSnackBarStateShoudBeTrue() =
        runTest {
            val email = "paria.m7616@gmail.com"
            forgetPasswordUseCase = mockk {
                coEvery {
                    this@mockk.invoke(any())
                } returns ForgetPasswordResponse(true)
            }

            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            assertTrue(viewModel.state.value.isDisplayedSnackbar)
        }

    @Test
    fun givenWrongEmail_WhenEmailChangedAndSubmitButtonClicked_ThenSnackBarStateShoudBeFalse() =
        runTest {
            val email = "paria.m7616gmail.com"
            forgetPasswordUseCase = mockk {
                coEvery {
                    this@mockk.invoke(any())
                } returns ForgetPasswordResponse(false)
            }

            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            assertFalse(viewModel.state.value.isDisplayedSnackbar)
        }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitButtonClicked_ThenSnackBarMessageIsSuccess() =
        runTest {
            val email = "paria.m7616@gmail.com"
            forgetPasswordUseCase = mockk(relaxed = true) {
                coEvery {
                    this@mockk.invoke(email)
                } returns ForgetPasswordResponse(true)
            }
            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)

            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            val effect = viewModel.efectFlow.first()
            effect as ForgetPasswordEffect.ShowSnackbar
            assertEquals("success", effect.message)
        }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitButtonClickedAndForgetPasswordFailed_ThenSnackBarMessageIsFailed() =
        runTest {
            val email = "paria.m7616@gmail.com"
            forgetPasswordUseCase = mockk(relaxed = true) {
                coEvery {
                    this@mockk.invoke(email)
                } returns ForgetPasswordResponse(false)
            }
            viewModel = ForgetPasswordViewModel(forgetPasswordUseCase)

            viewModel.onEvent(ForgetPasswordEvent.OnEmailChanged(email))
            viewModel.onEvent(ForgetPasswordEvent.OnSubmitButtonClicked)
            val effect = viewModel.efectFlow.first()
            effect as ForgetPasswordEffect.ShowSnackbar
            assertEquals("failed", effect.message)
        }
}