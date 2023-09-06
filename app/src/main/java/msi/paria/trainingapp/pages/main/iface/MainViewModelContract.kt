package msi.paria.trainingapp.pages.main.iface

import androidx.compose.runtime.State
import msi.paria.trainingapp.pages.main.state.MainPageState

interface MainViewModelContract {

    fun setEmail(email : String)

    fun getEmail(): String

    fun getPageState(): State<MainPageState>
    fun onSubmitClicked()

}