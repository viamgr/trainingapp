package com.training.app.trainingapp.main.view

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


@Composable
fun RegisterPageView(
    userEmail: String, emailValidateState: Boolean, onEmailChanged: (newEmail: String) -> Unit, onSubmitButtonClick: () -> Unit
) {
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextFiledView(
            Modifier
                .fillMaxWidth()
                .testTag(TestTags.EMAIL_TEXT_FILED_ID), userEmail, emailValidateState, onEmailChanged
        )
        RoundButtonView(
            Modifier
                .fillMaxWidth()
                .testTag(TestTags.CHECK_BUTTON_ID), stringResource(id = R.string.check), onSubmitButtonClick
        )
    }
}


@Preview
@Composable
fun ShowRegisterPageView() {
    RegisterPageView("email", false, {}, {})
}