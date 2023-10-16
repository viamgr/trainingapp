package com.training.app.data.authorization.forgetpassword.repo

import com.training.app.data.authorization.forgetpassword.dataprovider.ForgetPasswordDataProvider
import com.training.app.data.authorization.forgetpassword.dto.ForgetPasswordResponse

class ForgetPasswordRepositoryImpl constructor(private val dataProvider: ForgetPasswordDataProvider) : ForgetPasswordRepository {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        return dataProvider.forgetPassword(email)
    }
}