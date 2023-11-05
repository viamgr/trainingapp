package com.training.trainingapp.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.training.app.trainingapp.main.view.navigation.MainApp
import com.training.app.trainingapp.utils.Screen
import com.training.app.trainingapp.utils.TestTags
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupMainNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MainApp(navController = navController)
        }
    }

    @Test
    fun mainNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Register.name)
    }

    @Test
    fun mainNavHost_clickOnForgetPasswordText_navigatesToForgetPasswordScreen() {
        composeTestRule.onNodeWithTag(TestTags.FORGET_PASSWORD_TEXT_ID)
            .performClick()
        navController.assertCurrentRouteName(Screen.ForgetPassword.name)
    }

    @Test
    fun mainNavHost_clickBackOnForgetPasswordScreen_navigatesToRegisterScreen() {
        navigateToForgetPasswordScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(Screen.Register.name)
    }

    private fun navigateToForgetPasswordScreen() {
        composeTestRule.onNodeWithTag(TestTags.FORGET_PASSWORD_TEXT_ID)
            .performClick()
    }

    private fun performNavigateUp() {
        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
    }

}