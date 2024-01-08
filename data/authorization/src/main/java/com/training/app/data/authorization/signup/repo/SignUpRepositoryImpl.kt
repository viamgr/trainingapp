package com.training.app.data.authorization.signup.repo

import com.training.app.data.authorization.signup.dataprovider.SignUpDataProvider
import com.training.app.data.authorization.signup.dto.SignUpModelResponseAdapter
import com.trainning.app.domain.model.SignUpResponse
import com.trainning.app.domain.repository.SignUpRepository
import javax.inject.Inject

internal class SignUpRepositoryImpl @Inject constructor(private val dataProvider: SignUpDataProvider) :
    SignUpRepository {
    override suspend fun signup(email: String): SignUpResponse {
        return SignUpModelResponseAdapter(dataProvider.register(email)).map()
    }
}