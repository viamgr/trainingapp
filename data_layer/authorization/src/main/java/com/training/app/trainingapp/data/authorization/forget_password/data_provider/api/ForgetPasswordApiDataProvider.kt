package com.training.app.trainingapp.data.authorization.forget_password.data_provider.api

import com.training.app.trainingapp.data.authorization.forget_password.data_provider.ForgetPasswordDataProviderImpl
import com.training.app.trainingapp.data.authorization.forget_password.dto.ForgetPasswordResponse

class ForgetPasswordApiDataProvider : ForgetPasswordDataProviderImpl() {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        return ForgetPasswordResponse(isSuccess = false)
    }
}