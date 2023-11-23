package com.training.app.data.authorization.signup.dataprovider

import com.training.app.data.authorization.signup.dto.SignUpModelResponse
import kotlinx.coroutines.delay

internal class SignUpDataProviderImpl : SignUpDataProvider {
    override suspend fun register(email: String): SignUpModelResponse {
        delay(1000)
        return SignUpModelResponse(isSuccess = (0..3).random() % 3 != 2)
    }
}