package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordModelResponse

internal class ForgetPasswordDataProviderImpl : ForgetPasswordDataProvider {
    override suspend fun forgetPassword(email: String): ForgetPasswordModelResponse {
        return ForgetPasswordModelResponse(isSuccess = false)
    }
}