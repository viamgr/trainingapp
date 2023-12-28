package com.training.app.data.authorization.signup.dataprovider

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


internal class SignUpDataProviderImplTest {

    private lateinit var dataProvider: SignUpDataProvider

    @Before
    fun initValues() {
        dataProvider = SignUpDataProviderImpl()
    }

    @Test
    fun givenEmail_whenEmailSend_thenThrowException() = runTest {
        val result = dataProvider.register("")
        assertEquals(result.isSuccess, false)
    }

}