package msi.paria.trainingapp.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import msi.paria.trainingapp.R
import msi.paria.trainingapp.pages.main.view.RegisterPageView
import msi.paria.trainingapp.pages.main.view_model.RegisterViewModel


class MainActivity : ComponentActivity() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                RegisterPageView("textFiledId", registerViewModel.userEmail.collectAsState().value,
                    registerViewModel.emailValidateState.collectAsState().value,
                    onEmailChanged = {
                        registerViewModel.onEmailChanged(it)
                    },
                    "buttonId",
                    stringResource(id = R.string.check),
                    onSubmitButtonClick = {
                        registerViewModel.onSubmitButtonClicked()
                    })
            }
        }
    }

}

