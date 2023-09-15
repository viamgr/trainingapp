package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import msi.paria.trainingapp.widgets.buttons.RoundButtonView
import msi.paria.trainingapp.widgets.textFileds.EmailTextFiledView


@Composable
fun RegisterPageView(
    emailTextFiledId: String, userEmail: String, emailValidateState: Boolean, onEmailChanged: (newEmail: String) -> Unit,
    buttonFiledId: String, buttonText: String, onSubmitButtonClick: () -> Unit
) {

    if (emailTextFiledId == buttonFiledId)
        throw IllegalArgumentException("emailTextFiledId must not equal's buttonFiledId. choose another ids form them.")

    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextFiledView(emailTextFiledId, userEmail, emailValidateState, onEmailChanged)
        RoundButtonView(buttonFiledId, buttonText, onSubmitButtonClick)
    }
}


@Preview
@Composable
fun ShowRegisterPageView() {
    RegisterPageView("id1", "email", false, {}, "id2", "check", {})
}