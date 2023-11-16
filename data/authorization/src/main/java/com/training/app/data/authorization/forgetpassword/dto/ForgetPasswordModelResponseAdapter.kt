package com.training.app.data.authorization.forgetpassword.dto

import com.trainning.app.domain.model.ForgetPasswordResponse

internal class ForgetPasswordModelResponseAdapter constructor(val modelResponse: ForgetPasswordModelResponse) {

    fun map(): ForgetPasswordResponse {
        return ForgetPasswordResponse(modelResponse.isSuccess)
    }

}
