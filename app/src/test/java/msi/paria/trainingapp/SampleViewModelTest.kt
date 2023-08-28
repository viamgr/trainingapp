package msi.paria.trainingapp

import org.junit.Test

class SampleViewModelTest {
    @Test
    fun validate_email_isCorrect(){
        val sampleViewModel = SampleViewModel()
        val expected = true
        val email = "paria.m7616@gmail.com"
        assert(expected) { sampleViewModel.onSubmitButtonClicked(email) }
    }
}