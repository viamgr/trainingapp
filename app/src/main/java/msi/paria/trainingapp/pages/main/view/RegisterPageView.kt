package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import msi.paria.trainingapp.widgets.buttons.RoundButtonView
import msi.paria.trainingapp.widgets.textFileds.EmailTextFiledView


@Composable
fun RegisterPageView(
    userEmail: String, emailValidateState: Boolean, onEmailChanged: (newEmail: String) -> Unit,
    buttonText: String, onSubmitButtonClick: () -> Unit
) {

    val textFiledId = "textFiledId"
    val buttonId = "buttonId"

    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextFiledView(
            Modifier
                .fillMaxWidth()
                .testTag(textFiledId), userEmail, emailValidateState, onEmailChanged)
        RoundButtonView(
            Modifier
                .fillMaxWidth()
                .testTag(buttonId), buttonText, onSubmitButtonClick)
    }
}


@Preview
@Composable
fun ShowRegisterPageView() {
    RegisterPageView("email", false, {}, "check", {})
}