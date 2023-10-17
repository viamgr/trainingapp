package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordResponse
import kotlinx.coroutines.delay

class ForgetPasswordDataProviderImpl : ForgetPasswordDataProvider {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        delay(1000)
        return ForgetPasswordResponse(isSuccess = (0..3).random() % 3 != 2)
    }
}