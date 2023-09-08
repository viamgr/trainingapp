package msi.paria.trainingapp.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import msi.paria.trainingapp.pages.main.view.RegisterPageView
import msi.paria.trainingapp.pages.main.view_model.RegisterViewModel


class MainActivity : ComponentActivity() {

    lateinit var mainActivityViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                RegisterPageView(mainActivityViewModel.userEmail,
                    mainActivityViewModel.emailValidateState,
                    onEmailChanged = {
                        mainActivityViewModel.onEmailChanged(it)
                    },
                    onSubmitButtonClick = {
                        mainActivityViewModel.onSubmitButtonClicked()
                    })
            }
        }
    }

}

