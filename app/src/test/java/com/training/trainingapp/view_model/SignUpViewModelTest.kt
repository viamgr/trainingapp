package com.training.trainingapp.view_model

import app.cash.turbine.test
import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.view_model.signup.SignUpViewModel
import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.usecase.SignUpViewUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class SignUpViewModelTest {
    lateinit var sampleViewModel: SignUpViewModel

    val signUpViewUseCase = mockk<SignUpViewUseCase>()

    @Before
    fun initValues() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        sampleViewModel = SignUpViewModel(signUpViewUseCase)
    }

    @Test
    fun givenEmail_WhenEmailChanged_ThenViewModelEmailMustBeChanged() {
        var email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        assertEquals(sampleViewModel.pageState.value.email, email)

        email = "paria"
        sampleViewModel.onEmailChanged(email)
        assertEquals(sampleViewModel.pageState.value.email, email)

        email = ""
        sampleViewModel.onEmailChanged(email)
        assertEquals(sampleViewModel.pageState.value.email, email)
    }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenViewModelEmailValidateShouldBeTrue() {
        coEvery { signUpViewUseCase.invoke(any()) } returns SignUpResponse(true)

        val email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun givenWrongEmail_WhenEmailChangedAndSubmitClicked_ThenViewModelEmailValidateShouldBeFalse() {
        val email = "paria."
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun givenEmptyEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        val email = ""
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenPageStateMustBeSuccess() = runTest {
        coEvery { signUpViewUseCase.invoke(any()) } coAnswers {
            delay(10)
            SignUpResponse(true)
        }
        val email = "paria.m7616@gmial.com"

        sampleViewModel.pageState.test {
            sampleViewModel.onEmailChanged(email)
            assertEquals(PageState.IDLE, awaitItem().pageState)

            sampleViewModel.onSubmitButtonClicked()
            assertEquals(PageState.IDLE, awaitItem().pageState)
            assertEquals(PageState.LOADING, awaitItem().pageState)
            assertEquals(PageState.SUCCESS, awaitItem().pageState)
        }
    }

    @Test
    fun givenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenPageStateMustBeFailed() = runTest {
        coEvery { signUpViewUseCase.invoke(any()) } coAnswers {
            delay(10)
            SignUpResponse(false)
        }
        val email = "paria.m7616@gmial.com"

        sampleViewModel.pageState.test {
            sampleViewModel.onEmailChanged(email)
            assertEquals(PageState.IDLE, awaitItem().pageState)

            sampleViewModel.onSubmitButtonClicked()
            assertEquals(PageState.IDLE, awaitItem().pageState)
            assertEquals(PageState.LOADING, awaitItem().pageState)
            assertEquals(PageState.FAILED, awaitItem().pageState)
        }
    }


    @After
    fun close() {
        Dispatchers.shutdown()
    }

}