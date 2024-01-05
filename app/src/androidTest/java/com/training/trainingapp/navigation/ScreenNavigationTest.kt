package com.training.trainingapp.navigation

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.training.app.trainingapp.main.view.navigation.MainApp
import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel
import com.training.app.trainingapp.main.viewmodel.signup.SignUpViewModel
import com.training.app.trainingapp.utils.Screen
import com.training.app.trainingapp.utils.TestTags
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.usecase.ForgetPasswordUseCase
import com.trainning.app.domain.usecase.SignUpViewUseCase
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    val signUpViewUseCase = mockk<SignUpViewUseCase>()
    val forgetPasswordUseCase = mockk<ForgetPasswordUseCase>()

    @Before
    fun setupMainNavHost() {
        coEvery { signUpViewUseCase.invoke(any()) } returns SignUpResponse(true)
        coEvery { forgetPasswordUseCase.invoke(any()) } returns ForgetPasswordResponse(true)

        val signUpViewModel = SignUpViewModel(signUpViewUseCase)
        val forgetPasswordViewModel = ForgetPasswordViewModel(forgetPasswordUseCase)

        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MainApp(signUpViewModel, forgetPasswordViewModel, navController = navController)
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
    fun mainNavHost_ClickBackOnForgetPasswordScreen_NavigatesToRegisterScreen() {
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