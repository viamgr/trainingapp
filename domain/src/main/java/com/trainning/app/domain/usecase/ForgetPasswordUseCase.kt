package com.trainning.app.domain.usecase

import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository

class ForgetPasswordUseCase(private val repository: ForgetPasswordRepository) {
    suspend operator fun invoke(email: String): ForgetPasswordResponse {
        return repository.forgetPassword(email)
    }
}