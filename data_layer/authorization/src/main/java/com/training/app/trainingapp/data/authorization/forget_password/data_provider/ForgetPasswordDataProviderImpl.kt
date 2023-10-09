package com.training.app.trainingapp.data.authorization.forget_password.data_provider

import com.training.app.trainingapp.data.authorization.forget_password.dto.ForgetPasswordResponse

abstract class ForgetPasswordDataProviderImpl {

    abstract suspend fun forgetPassword(email: String): ForgetPasswordResponse

}