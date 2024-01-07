package com.training.app.trainingapp.utils

import androidx.annotation.StringRes
import com.training.app.trainingapp.R

enum class Screen(@StringRes val title: Int) {
    Register(title = R.string.register),
    ForgetPassword(title = R.string.forget_password),
}