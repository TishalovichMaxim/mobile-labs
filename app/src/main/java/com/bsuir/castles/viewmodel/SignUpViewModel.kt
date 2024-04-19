package com.bsuir.castles.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
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

    @SuppressLint("SimpleDateFormat")
    fun getDateString(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        date?.let {
            return dateFormat.format(it)
        }

        return "Choose.."
    }

    suspend fun signUp() {
        val res = Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .await()

        if (res.user == null) {
            //bad auth
            return
        }

        val user = {
            "bio" to bio
            "birthdate" to date
            "firstname" to firstName
            "lastname" to lastName
        }

        val storingRes = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .add(user)
            .await()

        goToSignInScreen()
    }

    fun goToSignInScreen() {
        Router.instance.route(Screen.SignIn)
    }
}