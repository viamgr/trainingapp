package msi.paria.trainingapp

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    private lateinit var viewModelImpl: MainViewModelImpl

    private val _state = mutableStateOf(MainPageState())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                view()
            }
        }

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


    }


    @Composable
    fun view() {
        val state by viewModelImpl.getPageState()

        Column(
            Modifier.padding(all = 16.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(state.email, onValueChange = {
                viewModelImpl.setEmail(it)
            }, modifier = Modifier.fillMaxWidth(), isError = !state.isEmailCorrect)
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModelImpl.onSubmitClicked()
                }, content = {
                    Text(getString(R.string.check))
                })
        }
    }


}

