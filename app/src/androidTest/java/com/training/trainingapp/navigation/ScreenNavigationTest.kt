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
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainScreenNavigationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupMainNavHost() {
        hiltRule.inject()

        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MainApp(navController = navController)
        }
    }

    @Test
    fun mainNavHost_VerifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Register.name)
    }

    @Test
    fun mainNavHost_ClickOnForgetPasswordText_NavigatesToForgetPasswordScreen() {
        navigateToForgetPasswordScreen()
        navController.assertCurrentRouteName(Screen.ForgetPassword.name)
    }

    @Test
    fun mainNavHost_ClickBackOnForgetPasswordScreen_NavigatesToRegisterScreen(){
        navigateToForgetPasswordScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(Screen.Register.name)
    }

    private fun navigateToForgetPasswordScreen() {
        composeTestRule.onNodeWithTag(TestTags.FORGET_PASSWORD_TEXT_ID)
            .performClick()
    }

    private fun performNavigateUp() {
        composeTestRule.runOnIdle {
            navController.navigateUp()
        }
    }

}