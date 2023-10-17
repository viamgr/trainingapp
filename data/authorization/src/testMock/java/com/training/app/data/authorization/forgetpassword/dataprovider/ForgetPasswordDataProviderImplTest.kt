package com.training.app.data.authorization.forgetpassword.dataprovider

import org.junit.Before
import org.junit.Test


class ForgetPasswordDataProviderImplTest {

    private lateinit var dataProvider: ForgetPasswordDataProvider

    @Before
    fun initValues() {
        dataProvider = ForgetPasswordDataProviderImpl()
    }

    @Test
    fun givenEmail_whenEmailSend_thenThrowException() {
//        val result = dataProvider.forgetPassword("")
//        assertEquals(result.isSuccess, false)
    }

}