package com.trainning.app.domain.repository

import com.trainning.app.domain.model.ForgetPasswordResponse

interface ForgetPasswordRepository {
    suspend fun forgetPassword(email: String):ForgetPasswordResponse
}