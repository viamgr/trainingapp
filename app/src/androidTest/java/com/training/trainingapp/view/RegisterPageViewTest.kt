package com.training.trainingapp.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.training.app.trainingapp.utils.TestTags
import com.training.app.trainingapp.main.view.RegisterPageView
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

        composeTestRule.onNodeWithTag(TestTags.EMAIL_TEXT_FILED_ID).assertExists()
        composeTestRule.onNodeWithTag(TestTags.CHECK_BUTTON_ID).assertExists()
    }

}