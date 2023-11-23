package com.training.app.data.authorization.signup.repo

import com.training.app.data.authorization.signup.dataprovider.SignUpDataProvider
import com.training.app.data.authorization.signup.dto.SignUpModelResponseAdapter
import com.trainning.app.domain.model.RegisterResponse
import com.trainning.app.domain.repository.RegisterRepository
import javax.inject.Inject

internal class SignUpRepositoryImpl @Inject constructor(private val dataProvider: SignUpDataProvider) : RegisterRepository {
    override suspend fun register(email: String): RegisterResponse {
        return SignUpModelResponseAdapter(dataProvider.register(email)).map()
    }
}