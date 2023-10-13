package com.training.app.trainingapp.view.components.textFileds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun EmailTextFiledView(modifier: Modifier, email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
    TextField(
        email, onValueChange = {
            onEmailChanged(it)
        }, modifier = modifier, isError = !isEmailCorrect, singleLine = true
    )
}


@Preview
@Composable
fun ErrorEmailTextFiledView() {
    EmailTextFiledView(modifier = Modifier.fillMaxWidth(), "aaaa", false, {})
}

@Preview
@Composable
fun CorrectEmailTextFiledView() {
    EmailTextFiledView(modifier = Modifier.fillMaxWidth(), "a@b.com", true, {})
}