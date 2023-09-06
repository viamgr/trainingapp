package msi.paria.trainingapp.pages.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import msi.paria.trainingapp.R
import msi.paria.trainingapp.pages.main.iface.MainViewModelContract
import msi.paria.trainingapp.pages.main.state.MainPageState


@Composable
fun MainPageView(mainPagePresenter: MainViewModelContract) {
    val pageState = mainPagePresenter.getPageState()
    Column(
        Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(pageState.value.email, onValueChange = {
            mainPagePresenter.setEmail(it)
        }, modifier = Modifier.fillMaxWidth(), isError = !pageState.value.isEmailCorrect)
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                mainPagePresenter.onSubmitClicked()
            }, content = {
                Text(stringResource(R.string.check))
            })
    }
}


@Preview
@Composable
fun ErrorPageView() {
    MainPageView(getSimplePresenter(MainPageState("invalid data", false)))
}

@Preview
@Composable
fun CorrectPageView() {
    MainPageView(getSimplePresenter(MainPageState("a@b.com", true)))
}

fun getSimplePresenter(pageState: MainPageState): MainViewModelContract {
    return object : MainViewModelContract {
        override fun setEmail(email: String) {
        }

        override fun getEmail(): String {
            return pageState.email
        }

        override fun getPageState(): State<MainPageState> {
            return mutableStateOf(pageState)
        }


        override fun onSubmitClicked() {}
    }
}