package com.training.trainingapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.training.app.trainingapp.main.view.forget_password.ForgetPasswordScreen
import com.training.app.trainingapp.main.view.register.RegisterScreen
import com.training.app.trainingapp.main.view_model.ForgetPasswordViewModel
import com.training.app.trainingapp.main.view_model.RegisterViewModel
import com.training.app.trainingapp.utils.Screen
import com.training.app.trainingapp.utils.TestTags
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    private val navController = TestNavHostController(appContext)

    @get: Rule
    val composeTestRule = createComposeRule()
    @Test
    fun testNavigationFromRegisterScreenToForgetPasswordScreen() {
        composeTestRule.setContent {
            NavHost(navController, startDestination = Screen.Register.name) {
                composable(Screen.Register.name) {
                    RegisterScreen(
                        navController = navController,
                        registerViewModel = RegisterViewModel()
                    )
                }
                composable(Screen.ForgetPassword.name) {
                    ForgetPasswordScreen(viewModel = ForgetPasswordViewModel())
                }
            }
        }
        val forgotPasswordLink = composeTestRule.onNodeWithTag(TestTags.FORGET_PASSWORD_TEXT_ID)
        forgotPasswordLink.performClick()
        assertEquals(navController.currentDestination?.route, Screen.ForgetPassword.name)
    }
}