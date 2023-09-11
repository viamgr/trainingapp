package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import msi.paria.trainingapp.R


@Composable
fun RegisterPageView(userEmail: String, emailValidateState: Boolean, onEmailChanged: (newEmail: String) -> Unit, onSubmitButtonClick: () -> Unit) {
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFiledView(userEmail, emailValidateState, onEmailChanged)
        CheckButtonView(onSubmitButtonClick)
    }
}

@Composable
fun TextFiledView(email: String, isEmailCorrect: Boolean, onEmailChanged: (newEmail: String) -> Unit) {
    TextField(email, onValueChange = {
        onEmailChanged(it)
    }, modifier = Modifier.fillMaxWidth().testTag("textFiled"), isError = !isEmailCorrect)
}

@Composable
fun CheckButtonView(onSubmitButtonClick: () -> Unit) {
    Button(modifier = Modifier.fillMaxWidth().testTag("button"),
        onClick = onSubmitButtonClick, content = {
            Text(stringResource(R.string.check))
        })
}


@Preview
@Composable
fun IncorrectEmailRegisterPageView() {
    RegisterPageView("aaaa", false, {}, {})
}

@Preview
@Composable
fun CorrectEmailRegisterPageView() {
    RegisterPageView("a@b.com", true, {}, {})
}


@Preview
@Composable
fun ErrorTextFiledView() {
    TextFiledView("aaaa", false, {})
}

@Preview
@Composable
fun CorrectTextFiledView() {
    TextFiledView("a@b.com", true, {})
}

@Preview
@Composable
fun CheckButtonPreview() {
    CheckButtonView {}
}