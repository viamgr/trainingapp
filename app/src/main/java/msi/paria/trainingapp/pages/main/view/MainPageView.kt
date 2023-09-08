package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow
import msi.paria.trainingapp.R


@Composable
fun MainPageView(userEmail: StateFlow<String>, emailValidateState: StateFlow<Boolean>, onEmailChanged: (newEmail: String) -> Unit, onSubmitButtonClick: () -> Unit) {
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFiledView(userEmail.collectAsState().value, emailValidateState.collectAsState().value, onEmailChanged)
        CheckButtonView(onSubmitButtonClick)
    }
}

@Composable
fun TextFiledView(email: String, isEmailCorrect: Boolean, setEmail: (newEmail: String) -> Unit) {
    TextField(email, onValueChange = {
        setEmail(it)
    }, modifier = Modifier.fillMaxWidth(), isError = !isEmailCorrect)
}

@Composable
fun CheckButtonView(onSubmitButtonClick: () -> Unit) {
    Button(modifier = Modifier.fillMaxWidth(),
        onClick = {
            onSubmitButtonClick.invoke()
        }, content = {
            Text(stringResource(R.string.check))
        })
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