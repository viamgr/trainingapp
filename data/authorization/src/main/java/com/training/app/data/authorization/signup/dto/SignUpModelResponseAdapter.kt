package com.training.app.data.authorization.signup.dto

import com.trainning.app.domain.model.RegisterResponse

internal class SignUpModelResponseAdapter constructor(val modelResponse: SignUpModelResponse) {

    fun map(): RegisterResponse {
        return RegisterResponse(modelResponse.isSuccess)
    }

}
