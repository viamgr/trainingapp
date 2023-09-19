package msi.paria.trainingapp.widgets.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class RoundButtonKtTest {

    private val id = "id"

    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun givenName_WhenViewCreate_ThenShouldButtonTextSameAsGivenName() {
        val name = "name"
        showSampleCheckButton(name) {}

        composeTestRule.onNodeWithTag(id).assertTextEquals(name)
    }

    @Test
    fun givenView_WhenViewCreate_ThenShouldButtonDisplayed() {
        showSampleCheckButton("") {}

        composeTestRule.onNodeWithTag(id).assertExists()
    }

    @Test
    fun givenView_WhenButtonClicked_ThenShouldButtonClicked() {
        var clicked = false

        showSampleCheckButton("") { clicked = true }

        composeTestRule.onNodeWithTag(id).performClick()
        TestCase.assertEquals(clicked, true)
    }

    private fun showSampleCheckButton(name: String, onSubmitButtonClick: () -> Unit) {
        composeTestRule.setContent {
            RoundButtonView(
                Modifier
                    .fillMaxWidth()
                    .testTag(id),
                name,
                onSubmitButtonClick = onSubmitButtonClick
            )
        }
    }

}