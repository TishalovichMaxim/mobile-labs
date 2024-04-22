package com.bsuir.castles.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.bsuir.castles.viewmodel.help.Router
import com.bsuir.castles.viewmodel.help.Screen
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
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

    fun signUp() {
        viewModelScope.launch {
            signUpSusp()
        }
    }

    private suspend fun signUpSusp() {
        val res: AuthResult
        try {
            res = Firebase.auth
                .createUserWithEmailAndPassword(email, password)
                .await()
        } catch (e: Exception) {
            Log.d("SIGN_UP", e.message ?: "Empty message")
            return
        }

        if (res.user == null) {
            //bad auth
            return
        }

        val user = hashMapOf(
            "bio" to bio,
            "birthdate" to date,
            "firstName" to firstName,
            "lastName" to lastName
        )

        try {
            val storingRes = Firebase.firestore
                .collection(FirestorePath.USERS.path)
                .document(res.user!!.uid)
                .set(user)
                .await()
        } catch (e: Exception) {
            Log.d("SIGN_UP", "Error in adding user info to firestore.")
            return
        }

        goToSignInScreen()
    }

    fun goToSignInScreen() {
        Router.instance.route(Screen.SignIn)
    }
}