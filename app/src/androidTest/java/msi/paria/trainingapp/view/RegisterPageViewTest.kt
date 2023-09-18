package msi.paria.trainingapp.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import msi.paria.trainingapp.pages.main.view.RegisterPageView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterPageViewTest {

    private val textFiledId = "textFiledId"
    private val buttonId = "buttonId"

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun givenView_WhenViewCreate_ThenShouldAllViewDisplayed() {

        composeTestRule.setContent {
            RegisterPageView(textFiledId, "",
                false,
                onEmailChanged = {
                },
                buttonId,
                "",
                onSubmitButtonClick = {
                })
        }

        composeTestRule.onNodeWithTag(textFiledId).assertExists()
        composeTestRule.onNodeWithTag(buttonId).assertExists()
    }

}