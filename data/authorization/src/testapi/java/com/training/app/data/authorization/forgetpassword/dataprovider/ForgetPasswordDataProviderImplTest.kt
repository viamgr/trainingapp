package com.training.app.data.authorization.forgetpassword.dataprovider

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class ForgetPasswordDataProviderImplTest {

    private lateinit var dataProvider: ForgetPasswordDataProvider

    @Before
    fun initValues() {
        dataProvider = ForgetPasswordDataProviderImpl()
    }

    @Test
    fun givenEmail_whenEmailSend_thenThrowException() = runTest {
        val result = dataProvider.forgetPassword("")
        assertEquals(result.isSuccess, false)
    }

}