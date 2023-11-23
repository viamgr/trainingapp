package com.trainning.app.domain.usecase

import com.trainning.app.domain.model.RegisterResponse
import com.trainning.app.domain.repository.RegisterRepository

class RegisterViewUseCase(private val repository: RegisterRepository) {
    suspend operator fun invoke(email: String): RegisterResponse {
        return repository.register(email)
    }
}