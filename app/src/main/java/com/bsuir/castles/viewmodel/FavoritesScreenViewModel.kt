package com.bsuir.castles.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.Castle
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await

class FavoritesScreenViewModel : ViewModel() {

    var searchText by mutableStateOf("")

    private var favorites: List<Castle> by mutableStateOf(listOf())

    fun getAllFavorites() : List<Castle> {
        if (searchText.isEmpty()) {
            return favorites
        }
        return favorites.filter {
            it.name.startsWith(searchText, true)
        }
    }

    suspend fun loadFavorites() {
        val castles = mutableListOf<Castle>()
        val castlesIds = mutableListOf<String>()

        val res = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .collection(FirestorePath.FAVORITES.path)
            .get()
            .await()

        val docs = res.documents
        for (doc in docs) {
            castlesIds.add(doc.id)
        }

        if (castlesIds.isEmpty()) {
            favorites = listOf()
            return
        }

        val snapshot = Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .whereIn(FieldPath.documentId(), castlesIds)
            .get()
            .await()

        val castlesDocs = snapshot.documents
        for (doc in castlesDocs) {
            val castle = doc.toObject<Castle>()
            castle!!.id = doc.id
            castles.add(castle)
        }

        favorites = castles
    }

}
