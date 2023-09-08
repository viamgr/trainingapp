package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import msi.paria.trainingapp.R
import msi.paria.trainingapp.pages.main.state.MainPageState


@Composable
fun MainPageView(pageState: State<MainPageState>, setEmail: (newEmail: String) -> Unit, onSubmitButtonClick: () -> Unit) {
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFiledView(pageState.value.email, pageState.value.isEmailCorrect, setEmail)
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