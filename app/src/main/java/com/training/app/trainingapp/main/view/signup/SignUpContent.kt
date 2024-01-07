package com.training.app.trainingapp.main.view.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.app.trainingapp.R
import com.training.app.trainingapp.utils.TestTags
import com.training.app.trainingapp.widgets.buttons.RoundButtonView
import com.training.app.trainingapp.widgets.textFileds.EmailTextFiledView
import com.training.app.trainingapp.widgets.texts.Text

@Composable
fun SignUpContent(
    userEmail: String,
    emailValidateState: Boolean,
    onEmailChanged: (newEmail: String) -> Unit,
    onSubmitButtonClick: () -> Unit,
    onForgetPasswordClick: () -> Unit
) {
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextFiledView(
            Modifier
                .fillMaxWidth()
                .testTag(TestTags.EMAIL_TEXT_FILED_ID),
            userEmail,
            emailValidateState,
            onEmailChanged
        )
        RoundButtonView(
            Modifier
                .fillMaxWidth()
                .testTag(TestTags.CHECK_BUTTON_ID),
            stringResource(id = R.string.check),
            onSubmitButtonClick
        )
        Text(
            modifier = Modifier
                .testTag(TestTags.FORGET_PASSWORD_TEXT_ID)
                .clickable {
                    onForgetPasswordClick()
                },
            text = stringResource(id = R.string.forget_password),
            onForgetPasswordClick
        )
    }
}


@Preview
@Composable
fun ShowSignUpContent() {
    SignUpContent("email", false, {}, {}, {})
}