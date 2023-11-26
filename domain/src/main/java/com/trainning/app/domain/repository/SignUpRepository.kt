package com.trainning.app.domain.repository

import com.trainning.app.domain.model.SignUpResponse

interface SignUpRepository {
    suspend fun signup(email: String): SignUpResponse
}