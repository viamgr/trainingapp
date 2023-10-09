package com.training.app.trainingapp.data.authorization.forget_password.data_provider.api

import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class ForgetPasswordApiDataProviderTest {

    lateinit var dataProvider: ForgetPasswordApiDataProvider

    @Before
    fun initValues() {
        dataProvider = ForgetPasswordApiDataProvider()
    }

    @Test
    fun givenEmail_whenEmailSend_thenThrowException() = runTest {
        val result = dataProvider.forgetPassword("")
        assertEquals(result.isSuccess , false)
    }

}