package com.bsuir.castles.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.User
import java.text.SimpleDateFormat

class ProfileScreenViewModel : ViewModel() {

    var user: User
        get() {
            return SharedData.user!!
        }
        set(value) {
            SharedData.user = value
        }

    fun logout() {
        SharedData.user = null

        Router.instance.route(Screen.SignIn)
    }

    @SuppressLint("SimpleDateFormat")
    fun getDateString() : String {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(user.birthdate)
    }

}