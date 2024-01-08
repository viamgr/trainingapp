package com.training.app.trainingapp.utils

import androidx.core.util.PatternsCompat

class RegexChecker {
    companion object {
        fun isEmailCorrect(email: String): Boolean {
            return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
        }
    }
}