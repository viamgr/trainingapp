package msi.paria.trainingapp.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import msi.paria.trainingapp.R
import msi.paria.trainingapp.pages.main.view.RegisterPageView
import msi.paria.trainingapp.pages.main.view_model.RegisterViewModel


class MainActivity : ComponentActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                RegisterPageView(registerViewModel.userEmail.collectAsState().value,
                    registerViewModel.emailValidateState.collectAsState().value,
                    onEmailChanged = {
                        registerViewModel.onEmailChanged(it)
                    },
                    stringResource(id = R.string.check),
                    onSubmitButtonClick = {
                        registerViewModel.onSubmitButtonClicked()
                    })
            }
        }
    }

}

