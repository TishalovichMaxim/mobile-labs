package com.bsuir.castles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Date

class SignUpViewModel : ViewModel() {

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    var confirmationPassword by mutableStateOf("")

    var firstName by mutableStateOf("")

    var lastName by mutableStateOf("")

    var bio by mutableStateOf("")

    var date: Date? by mutableStateOf(null)

    var showDatePicker by mutableStateOf(false)

    fun goToSignInScreen() {
        Router.instance.route(Screen.SignIn);
    }
}