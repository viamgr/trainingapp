package com.training.trainingapp.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.training.app.trainingapp.main.view.forgetpassword.ForgetPasswordContent
import com.training.app.trainingapp.main.view.forgetpassword.ForgetPasswordState
import com.training.app.trainingapp.utils.TestTags
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ForgetPasswordContentTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenView_WhenViewCreate_ThenShouldAllViewDisplayed() {

        composeTestRule.setContent {
            ForgetPasswordContent(
                ForgetPasswordState(),
                onEmailChanged = {
                },
                onSubmitButtonClick = {
                })
        }

        composeTestRule.onNodeWithTag(TestTags.PASSWORD_RECOVERY_EMAIL_TEXT_FILED_ID).assertExists()
        composeTestRule.onNodeWithTag(TestTags.PASSWORD_RECOVERY_BUTTON_ID).assertExists()
    }

}