package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordResponse

class ForgetPasswordDataProviderImpl : ForgetPasswordDataProvider {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        return ForgetPasswordResponse(isSuccess = false)
    }
}