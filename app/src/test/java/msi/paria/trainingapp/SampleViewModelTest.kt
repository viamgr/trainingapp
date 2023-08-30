package msi.paria.trainingapp

import org.junit.Test

class SampleViewModelTest {
    @Test
    fun validate_email_isCorrect(){
        val sampleViewModel = SampleViewModel()
        val email = "paria.m7616@gmail.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assert(true) { sampleViewModel.emailValidateState.value }
    }

    @Test
    fun email_isWrong(){
        val sampleViewModel = SampleViewModel()
        val email = "paria."
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assert(false) { sampleViewModel.emailValidateState.value }
    }
    @Test
    fun email_isEmpty(){
        val sampleViewModel = SampleViewModel()
        val email = ""
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assert(false) { sampleViewModel.emailValidateState.value }
    }
    @Test
    fun email_isCorrect_button_not_clicked(){
        val sampleViewModel = SampleViewModel()
        val email = "paria.m7616@gmail.com"
        sampleViewModel.onEmailChanged(email)
        assert(false) { sampleViewModel.emailValidateState.value }
    }
    @Test
    fun email_isCorrect_email_changed_not_received(){
        val sampleViewModel = SampleViewModel()
        val email = "paria.m7616@gmail.com"
        sampleViewModel.onSubmitButtonClicked()
        assert(false) { sampleViewModel.emailValidateState.value }
    }

}