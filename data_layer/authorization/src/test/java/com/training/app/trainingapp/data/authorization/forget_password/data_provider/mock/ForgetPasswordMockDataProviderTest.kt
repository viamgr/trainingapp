package com.training.app.trainingapp.data.authorization.forget_password.data_provider.mock

import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ForgetPasswordMockDataProviderTest {

    lateinit var dataProvider: ForgetPasswordMockDataProvider

    @Before
    fun initValues() {
        dataProvider = ForgetPasswordMockDataProvider()
    }

    @Test
    fun givenEmail_whenEmailSend_thenThrowException() = runTest {

    }

}