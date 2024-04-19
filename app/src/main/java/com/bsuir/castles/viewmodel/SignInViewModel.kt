package com.bsuir.castles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.User
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class SignInViewModel : ViewModel() {

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    private fun validateCredentials(): Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }

    fun goToSignUpScreen() {
        Router.instance.route(Screen.SignUp)
    }

    suspend fun signIn() {
        if (!validateCredentials()) {
            //add here some logic
            return
        }

        val authRes = Firebase.auth.signInWithEmailAndPassword(email, password).await()
        if (authRes.user == null) {
            return
        }

        val id = authRes.user!!.uid

        val fetchingRes = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .document(id)
            .get()
            .await()

        if (!fetchingRes.exists()) {
            //add here some logic
            return
        }

        val user = User(
            email,
            fetchingRes.getString("firstName")!!,
            fetchingRes.getString("lastName")!!,
            fetchingRes.getString("bio")!!,
            fetchingRes.getDate("birthdate")!!
        )

        SharedData.user = user

        Router.instance.route(Screen.Profile)
    }

}
