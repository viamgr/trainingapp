package com.training.app.trainingapp.feature_authentication.presentaion.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun RoundButtonView(modifier: Modifier, text: String, onSubmitButtonClick: () -> Unit) {
    Button(modifier = modifier,
        onClick = onSubmitButtonClick, content = {
            Text(text)
        })
}


@Preview
@Composable
fun CheckRoundButtonPreview() {
    RoundButtonView(Modifier.fillMaxWidth(), "check") {}
}