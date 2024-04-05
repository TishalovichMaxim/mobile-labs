package com.bsuir.castles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    private fun validateCredentials(): Boolean {
        return !(email.isEmpty() || password.isEmpty());
    }

}