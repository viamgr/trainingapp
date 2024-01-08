package com.training.app.data.authorization.forgetpassword.repo

import com.training.app.data.authorization.forgetpassword.dataprovider.ForgetPasswordDataProvider
import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordModelResponseAdapter
import com.trainning.app.domain.model.ForgetPasswordResponse
import com.trainning.app.domain.repository.ForgetPasswordRepository
import javax.inject.Inject

internal class ForgetPasswordRepositoryImpl @Inject constructor(private val dataProvider: ForgetPasswordDataProvider) :
    ForgetPasswordRepository {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        return ForgetPasswordModelResponseAdapter(dataProvider.forgetPassword(email)).map()
    }
}