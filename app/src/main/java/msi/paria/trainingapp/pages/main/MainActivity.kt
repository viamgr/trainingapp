package msi.paria.trainingapp.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import msi.paria.trainingapp.pages.main.iface.MainViewModelContract
import msi.paria.trainingapp.pages.main.state.MainPageState
import msi.paria.trainingapp.pages.main.view.MainPageView


class MainActivity : ComponentActivity() {

    private lateinit var viewModelImpl: MainViewModelContract

    private val _state = mutableStateOf(MainPageState())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelImpl = object : MainViewModelContract {
            override fun setEmail(email: String) {
                _state.value = _state.value.copy(email, email.contains("@"))
            }

            override fun getEmail(): String {
                return _state.value.email
            }

            override fun getPageState(): State<MainPageState> {
                return _state
            }

            override fun onSubmitClicked() {}
        }

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                MainPageView(mainPagePresenter = viewModelImpl)
            }
        }
    }

}

