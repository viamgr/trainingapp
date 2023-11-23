package com.training.app.data.authorization.signup.dataprovider

import com.training.app.data.authorization.signup.dto.SignUpModelResponse

interface SignUpDataProvider {
    suspend fun register(email: String): SignUpModelResponse
}