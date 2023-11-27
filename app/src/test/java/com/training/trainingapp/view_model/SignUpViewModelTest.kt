package com.training.trainingapp.view_model

import com.training.app.trainingapp.main.state.base.PageState
import com.training.app.trainingapp.main.state.signup.SignUpPageState
import com.training.app.trainingapp.main.view_model.signup.SignUpViewModel
import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.usecase.SignUpViewUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
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
    fun GivenEmail_WhenEmailChanged_ThenViewModelEmailMustBeChanged() {
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
    fun GivenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenViewModelEmailValidateShouldBeTrue() {
        coEvery { signUpViewUseCase.invoke(any()) } returns SignUpResponse(true)

        val email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun GivenWrongEmail_WhenEmailChangedAndSubmitClicked_ThenViewModelEmailValidateShouldBeFalse() {
        val email = "paria."
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun GivenEmptyEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        val email = ""
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.pageState.value.emailValidate)
    }

    @Test
    fun GivenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenCheckPageState() = runTest {
        coEvery { signUpViewUseCase.invoke(any()) } returns SignUpResponse(true)
        val email = "paria.m7616@gmial.com"

        val testResults = mutableListOf<SignUpPageState>()
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            sampleViewModel.pageState.toList(testResults)
        }

        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        advanceUntilIdle()

        assertEquals(4, testResults.size)
        assertEquals(PageState.IDLE, testResults[0].pageState)
        assertEquals(PageState.IDLE, testResults[1].pageState)
        assertEquals(email, testResults[1].email)
        assertEquals(PageState.LOADING, testResults[2].pageState)
        assertEquals(PageState.SUCCESS, testResults[3].pageState)

    }

    @After
    fun close() {
        Dispatchers.shutdown()
    }

}