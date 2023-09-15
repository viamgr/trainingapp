package msi.paria.trainingapp.widgets.textFileds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun EmailTextFiledView(id: String, email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
    TextField(
        email, onValueChange = {
            onEmailChanged(it)
        }, modifier = Modifier
            .fillMaxWidth()
            .testTag(id), isError = !isEmailCorrect, singleLine = true
    )
}


@Preview
@Composable
fun ErrorEmailTextFiledView() {
    EmailTextFiledView("", "aaaa", false, {})
}

@Preview
@Composable
fun CorrectEmailTextFiledView() {
    EmailTextFiledView("", "a@b.com", true, {})
}