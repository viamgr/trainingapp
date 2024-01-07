package com.training.app.trainingapp.widgets.texts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.training.app.trainingapp.R

@Composable
fun Text(modifier: Modifier, text: String, onClicked: () -> Unit) {
    Button(modifier = modifier, onClick = onClicked, content = {
        Text(text)
    })
}

@Preview
@Composable
fun TextPreview() {
    Text(Modifier.fillMaxWidth(), stringResource(id = R.string.forget_password)) {}
}