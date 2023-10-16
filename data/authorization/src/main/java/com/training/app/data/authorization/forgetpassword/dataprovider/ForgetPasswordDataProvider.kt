package com.training.app.data.authorization.forgetpassword.dataprovider

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordResponse

interface ForgetPasswordDataProvider {
    suspend fun forgetPassword(email: String): ForgetPasswordResponse
}