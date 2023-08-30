package msi.paria.trainingapp

import android.util.Patterns
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SampleViewModel : ViewModel() {

    private val _userEmail = MutableStateFlow("")
    val userEmail : StateFlow<String> = _userEmail

    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    private val _emailValidateState = MutableStateFlow(false)
    val emailValidateState : StateFlow<Boolean> = _emailValidateState

    fun validateEmail(){
        //_emailValidateState.value = _userEmail.value.matches(emailRegex.toRegex())
        _emailValidateState.value = PatternsCompat.EMAIL_ADDRESS.matcher(_userEmail.value).matches()
    }
    fun onEmailChanged(email: String){
        _userEmail.value = email
    }

    fun onSubmitButtonClicked(){
        validateEmail()
    }
}