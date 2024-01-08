package com.training.app.data.authorization.signup.dataprovider

import com.training.app.data.authorization.signup.dto.SignUpModelResponse

internal class SignUpDataProviderImpl : SignUpDataProvider {
    override suspend fun register(email: String): SignUpModelResponse {
        return SignUpModelResponse(isSuccess = false)
    }
}