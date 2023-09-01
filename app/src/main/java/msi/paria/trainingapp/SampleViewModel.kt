package msi.paria.trainingapp

import android.util.Patterns
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SampleViewModel : ViewModel() {

    private val _userEmail = MutableStateFlow("")
    val userEmail : StateFlow<String> = _userEmail


    private val _emailValidateState = MutableStateFlow(false)
    val emailValidateState : StateFlow<Boolean> = _emailValidateState

    fun validateEmail(){
        _emailValidateState.value = PatternsCompat.EMAIL_ADDRESS.matcher(_userEmail.value).matches()
    }
    fun onEmailChanged(email: String){
        _userEmail.value = email
    }

    fun onSubmitButtonClicked(){
        validateEmail()
    }
}