package msi.paria.trainingapp.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import msi.paria.trainingapp.pages.main.state.MainPageState
import msi.paria.trainingapp.pages.main.view.MainPageView


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val samplePageState = mutableStateOf(MainPageState())

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                MainPageView(pageState = samplePageState, onEmailChanged = {
                    samplePageState.value = samplePageState.value.copy(it, it.contains("@"))
                }, onSubmitButtonClick = {})
            }
        }
    }

}

