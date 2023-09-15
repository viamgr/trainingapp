package msi.paria.trainingapp.view

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import msi.paria.trainingapp.pages.main.view.CheckButtonView
import msi.paria.trainingapp.pages.main.view.RegisterPageView
import msi.paria.trainingapp.pages.main.view.TextFiledView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterPageViewTest {

    @get: Rule
    val composeTestRule = createComposeRule()
    

    @Test
    fun givenView_WhenViewCreate_ThenShouldAllViewDisplayed() {

        composeTestRule.setContent {
            RegisterPageView("",
                false,
                onEmailChanged = {
                },
                onSubmitButtonClick = {
                })
        }

        composeTestRule.onNodeWithTag("textFiled").assertExists()
        composeTestRule.onNodeWithTag("button").assertExists()
    }

    @Test
    fun givenView_WhenViewCreate_ThenShouldTextFieldDisplayed() {
        showSampleTextFiled("", false) {}
        composeTestRule.onNodeWithTag("textFiled").assertExists()
    }

    @Test
    fun givenEmail_WhenCreateTextFiledWithEmail_ThenTextFiledTextShouldBeSameAsGivenEmail() {
        val email = "email"

        showSampleTextFiled(email, false) {}

        composeTestRule.onNodeWithTag("textFiled").assertTextEquals(email)
    }

    @Test
    fun givenEmail_WhenEmailChanged_ThenTextFiledTextShouldBeSameAsEmail() {
        var email = ""

        showSampleTextFiled("", false) { email = it }

        composeTestRule.onNodeWithTag("textFiled").performTextInput("Hi")
        TestCase.assertEquals(email, "Hi")
    }

    @Test
    fun givenView_WhenViewCreate_ThenShouldCheckButtonDisplayed() {
        showSampleCheckButton {}

        composeTestRule.onNodeWithTag("button").assertExists()
    }

    @Test
    fun givenView_WhenButtonClicked_ThenShouldButtonClicked() {
        var clicked = false

        showSampleCheckButton { clicked = true }

        composeTestRule.onNodeWithTag("button").performClick()
        TestCase.assertEquals(clicked, true)
    }

    private fun showSampleTextFiled(email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
        composeTestRule.setContent {
            TextFiledView(
                email, isEmailCorrect,
                onEmailChanged = onEmailChanged
            )
        }
    }

    private fun showSampleCheckButton(onSubmitButtonClick: () -> Unit) {
        composeTestRule.setContent {
            CheckButtonView(
                onSubmitButtonClick = onSubmitButtonClick
            )
        }
    }

}