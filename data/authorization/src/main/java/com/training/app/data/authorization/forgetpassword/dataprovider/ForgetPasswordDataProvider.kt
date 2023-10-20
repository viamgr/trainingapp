package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordModelResponse

interface ForgetPasswordDataProvider {
    suspend fun forgetPassword(email: String): ForgetPasswordModelResponse
}