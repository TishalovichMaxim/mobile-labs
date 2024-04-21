package com.bsuir.castles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.Castle
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class CastlesViewModel : ViewModel() {

    var searchText by mutableStateOf("")

    private var castles: List<Castle> by mutableStateOf(listOf())

    fun getAllCastles(): List<Castle> {
        if (searchText.isEmpty()) {
            return castles
        }

        return castles.filter {
            it.name.startsWith(searchText, true)
        }
    }

    suspend fun loadCastles() {
        val castles = mutableListOf<Castle>()

        val res = Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .get()
            .await()

        val docs = res.documents
        for (doc in docs) {
            val castle = doc.toObject<Castle>()
            castle!!.id = doc.id
            castles.add(castle)
        }

        this.castles = castles
    }

    fun goToCastle(castle: Castle) {
        SharedData.castle = castle
        Router.instance.route(Screen.Castle)
    }

}