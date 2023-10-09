package com.training.app.trainingapp.data.authorization.forget_password.data_provider.mock

import com.training.app.trainingapp.data.authorization.forget_password.data_provider.ForgetPasswordDataProviderImpl
import com.training.app.trainingapp.data.authorization.forget_password.dto.ForgetPasswordResponse
import kotlinx.coroutines.*


class ForgetPasswordMockDataProvider : ForgetPasswordDataProviderImpl() {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        delay(1000)
        return ForgetPasswordResponse(isSuccess = (0..3).random() % 3 != 2)
    }
}