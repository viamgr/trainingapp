package msi.paria.trainingapp

import androidx.compose.runtime.State

interface MainViewModelImpl {

    fun setEmail(email : String)

    fun getEmail(): String

    fun getPageState(): State<MainPageState>
    fun onSubmitClicked()

}