package msi.paria.trainingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    private lateinit var viewModelImpl: MainViewModelImpl

    private val _state = mutableStateOf(MainPageState())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelImpl = object : MainViewModelImpl {
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

        val state by viewModelImpl.getPageState()


        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                PageView(state)
            }
        }
    }


    @Composable
    fun PageView(pageState: MainPageState ) {
        Column(
            Modifier.padding(all = 16.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(pageState.email, onValueChange = {
                viewModelImpl.setEmail(it)
            }, modifier = Modifier.fillMaxWidth(), isError = !pageState.isEmailCorrect)
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModelImpl.onSubmitClicked()
                }, content = {
                    Text(stringResource(R.string.check))
                })
        }
    }


    @Preview
    @Composable
    fun errorPageView() {
        PageView(pageState = MainPageState("invalid data" , false))
    }

    @Preview
    @Composable
    fun correctPageView() {
        PageView(pageState = MainPageState("a@b.com" , true))
    }


}

