package msi.paria.trainingapp.view_model

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import msi.paria.trainingapp.pages.main.view.RegisterPageView
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
    }

    @Test
    fun GivenView_WhenViewCreate_ThenMustFindAllViews() {
        composeTestRule.onNodeWithTag("textFiled").assertExists()
        composeTestRule.onNodeWithTag("button").assertExists()
    }

}