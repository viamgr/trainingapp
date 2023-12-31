package com.training.app.data.authorization.signup.dto

import com.trainning.app.domain.model.SignUpResponse

internal class SignUpModelResponseAdapter constructor(private val modelResponse: SignUpModelResponse) {

    fun map(): SignUpResponse {
        return SignUpResponse(modelResponse.isSuccess)
    }

}
