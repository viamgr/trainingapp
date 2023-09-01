package msi.paria.trainingapp

import io.bloco.faker.Faker
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SampleViewModelTest {
    lateinit var sampleViewModel: SampleViewModel
    lateinit var email : String
    lateinit var faker : Faker

    @Before
    fun initValues() {
        sampleViewModel = SampleViewModel()
        faker = Faker()
    }

    @Test
    fun test_email_isCorrect() {
        email = faker.internet.email()
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun test_email_isWrong() {
        email = "paria."
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun test_email_isEmpty() {
        email = ""
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun test_email_isCorrect_button_not_clicked() {
        email = faker.internet.email()
        sampleViewModel.onEmailChanged(email)
        assertFalse(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun test_email_isCorrect_email_changed_not_received() {
        email = faker.internet.email()
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }
    @Test
    fun test_multiple_email_entered() {
        email = faker.internet.email()
        email = faker.internet.email()
        email = "@gmail.com"
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }
    @Test
    fun test_several_time_button_clicked() {
        email = faker.internet.email()
        sampleViewModel.onEmailChanged(email)
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        assertTrue(sampleViewModel.emailValidateState.value)
    }

    @Test
    fun test_several_time_button_clicked_and_email_not_changed() {
        email = faker.internet.email()
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        sampleViewModel.onSubmitButtonClicked()
        assertFalse(sampleViewModel.emailValidateState.value)
    }

}