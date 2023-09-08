package msi.paria.trainingapp

import msi.paria.trainingapp.pages.main.view_model.RegisterViewModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SampleViewModelTest {
    lateinit var sampleViewModel: RegisterViewModel

    @Before
    fun initValues() {
        sampleViewModel = RegisterViewModel()
    }

    @Test
    fun GivenCorrectEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeTrue() {
        val email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun GivenWrongEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        val email = "paria."
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun GivenEmptyEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        val email = ""
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun GivenCorrectEmail_WhenEmailChangedAndSubmitNotClicked_ThenValidationShouldBeFalse() {
        val email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun GivenCorrectEmail_WhenEmailNotChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        val email = "paria.m7616@gmial.com"
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }
    @Test
    fun GivenMultipleEmail_WhenEmailChangedAndSubmitClicked_ThenValidationShouldBeFalse() {
        var email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        email = "pariamsi.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        email = "@gmail.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }
    @Test
    fun GivenCorrectEmail_WhenEmailChangedAndSubmitClickedSeveralTime_ThenValidationShouldBeTrue() {
        val email = "paria.m7616@gmial.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun GivenCorrectEmail_WhenEmailNotChangedAndSubmitClickedSeveralTime_ThenValidationShouldBeFalse() {
        val email = "paria.m7616@gmial.com"
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

}