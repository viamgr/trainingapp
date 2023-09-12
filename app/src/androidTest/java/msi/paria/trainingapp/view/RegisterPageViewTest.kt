package msi.paria.trainingapp.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterPageViewTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
    }

    @Test
    fun GivenView_WhenViewCreate_ThenMustFindAllViews() {

        composeTestRule.setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                RegisterPageView("",
                    false,
                    onEmailChanged = {
                    },
                    onSubmitButtonClick = {
                    })
            }
        }

        composeTestRule.onNodeWithTag("textFiled").assertExists()
        composeTestRule.onNodeWithTag("button").assertExists()
    }

    @Test
    fun GivenView_WhenViewCreate_ThenMustFindTextField() {
        showSampleTextFiled("", false) {}
        composeTestRule.onNodeWithTag("textFiled").assertExists()
    }

    @Test
    fun GivenEmail_WhenSendEmail_ThenTextFiledTextMustBeSame() {
        val email = "email"

        showSampleTextFiled(email, false) {}

        composeTestRule.onNodeWithTag("textFiled").assertTextEquals(email)
    }

    @Test
    fun GivenEmail_WhenChangeEmail_ThenTextFiledTextMustBeSame() {
        var email = ""

        showSampleTextFiled("", false) { email = it }

        composeTestRule.onNodeWithTag("textFiled").performTextInput("Hi")
        TestCase.assertEquals(email, "Hi")
    }

    @Test
    fun GivenView_WhenViewCreate_ThenMustFindCheckButton() {
        showSampleCheckButton {}

        composeTestRule.onNodeWithTag("button").assertExists()
    }

    @Test
    fun GivenView_WhenButtonClicked_ThenMustButtonClickBeTrue() {
        var clicked = false

        showSampleCheckButton { clicked = true }

        composeTestRule.onNodeWithTag("button").performClick()
        TestCase.assertEquals(clicked, true)
    }

    private fun showSampleTextFiled(email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
        composeTestRule.setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                TextFiledView(
                    email, isEmailCorrect,
                    onEmailChanged = onEmailChanged
                )
            }
        }
    }

    private fun showSampleCheckButton(onSubmitButtonClick: () -> Unit) {
        composeTestRule.setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                CheckButtonView(
                    onSubmitButtonClick = onSubmitButtonClick
                )
            }
        }
    }

}