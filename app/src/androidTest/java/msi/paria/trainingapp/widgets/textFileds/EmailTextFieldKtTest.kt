package msi.paria.trainingapp.widgets.textFileds

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class EmailTextFieldKtTest {

    private val id = "id"

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun givenView_WhenViewCreate_ThenShouldTextFieldDisplayed() {
        showSampleTextFiled("", false) {}
        composeTestRule.onNodeWithTag(id).assertExists()
    }

    @Test
    fun givenEmail_WhenCreateTextFiledWithEmail_ThenTextFiledTextShouldBeSameAsGivenEmail() {
        val email = "email"

        showSampleTextFiled(email, false) {}

        composeTestRule.onNodeWithTag(id).assertTextEquals(email)
    }

    @Test
    fun givenEmail_WhenEmailChanged_ThenTextFiledTextShouldBeSameAsEmail() {
        var email = ""

        showSampleTextFiled("", false) { email = it }

        composeTestRule.onNodeWithTag(id).performTextInput("Hi")
        TestCase.assertEquals(email, "Hi")
    }


    private fun showSampleTextFiled(email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
        composeTestRule.setContent {
            EmailTextFiledView(
                id,
                email, isEmailCorrect,
                onEmailChanged = onEmailChanged
            )
        }
    }

}