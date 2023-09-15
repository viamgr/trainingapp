package msi.paria.trainingapp.widgets.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun RoundButtonView(id: String, text: String, onSubmitButtonClick: () -> Unit) {
    Button(modifier = Modifier
        .fillMaxWidth()
        .testTag(id),
        onClick = onSubmitButtonClick, content = {
            Text(text)
        })
}


@Preview
@Composable
fun CheckRoundButtonPreview() {
    RoundButtonView("", "check") {}
}