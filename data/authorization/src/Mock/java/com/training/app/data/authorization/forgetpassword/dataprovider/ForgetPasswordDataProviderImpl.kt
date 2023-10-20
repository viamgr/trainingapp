package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordModelResponse
import kotlinx.coroutines.delay

class ForgetPasswordDataProviderImpl : ForgetPasswordDataProvider {
    override suspend fun forgetPassword(email: String): ForgetPasswordModelResponse {
        delay(1000)
        return ForgetPasswordModelResponse(isSuccess = (0..3).random() % 3 != 2)
    }
}