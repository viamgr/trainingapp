package com.training.app.data.authorization.forgetpassword.repo

import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordResponse

interface ForgetPasswordRepository {
    suspend fun forgetPassword(email: String): ForgetPasswordResponse
}