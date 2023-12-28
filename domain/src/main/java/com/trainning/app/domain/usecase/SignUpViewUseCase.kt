package com.trainning.app.domain.usecase

import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpViewUseCase @Inject constructor(private val repository: SignUpRepository) {
    suspend operator fun invoke(email: String): SignUpResponse {
        return repository.signup(email)
    }
}