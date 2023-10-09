package com.training.app.trainingapp.data.authorization.forget_password.repo

import com.training.app.trainingapp.data.authorization.forget_password.data_provider.ForgetPasswordDataProviderImpl
import com.training.app.trainingapp.data.authorization.forget_password.dto.ForgetPasswordResponse

class ForgetPasswordRepository constructor(private val dataProvider: ForgetPasswordDataProviderImpl) : ForgetPasswordDataProviderImpl() {
    override suspend fun forgetPassword(email: String): ForgetPasswordResponse {
        return dataProvider.forgetPassword(email)
    }
}