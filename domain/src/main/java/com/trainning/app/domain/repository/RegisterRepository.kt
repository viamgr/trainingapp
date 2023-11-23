package com.trainning.app.domain.repository

import com.trainning.app.domain.model.RegisterResponse

interface RegisterRepository {
    suspend fun register(email: String): RegisterResponse
}