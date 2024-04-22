package com.bsuir.castles.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.castles.model.Castle
import com.bsuir.castles.model.Review
import com.bsuir.castles.viewmodel.help.FirestorePath
import com.bsuir.castles.viewmodel.help.SharedData
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CastleViewModel : ViewModel() {

    var isReviewPresent by mutableStateOf(true)
        private set

    var sliderPosition by mutableFloatStateOf(0.5f)

    var comment by mutableStateOf("")

    var images by mutableStateOf(listOf<String>())

    var reviews by mutableStateOf(listOf<Review>())

    var icon by mutableStateOf(Icons.Sharp.FavoriteBorder)
        private set

    var isInFavorites = false
        private set(value) {
            icon = if (value) {
                Icons.Filled.Favorite
            } else {
                Icons.Sharp.FavoriteBorder
            }

            field = value
        }

    fun getRate() : Int {
        return (sliderPosition * 10 + 0.5f).toInt()
    }

    fun getCastle(): Castle {
        return SharedData.castle!!
    }

    fun loadCastleInfo() {
        viewModelScope.launch {
            loadCastleInfoSusp()
        }
    }

    private suspend fun loadCastleInfoSusp() {
        loadIsReviewPresent()
        loadIsInFavorites()
        loadImages()
        loadReviews()
    }

    private suspend fun loadIsInFavorites() {
        val res = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .collection(FirestorePath.FAVORITES.path)
            .document(getCastle().id)
            .get()
            .await()

        isInFavorites = res.exists()
    }

    private suspend fun addToFavorites() {
        val res = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .collection(FirestorePath.FAVORITES.path)
            .document(getCastle().id)
            .set(hashMapOf<String, String>())
            .await()

        isInFavorites = true
    }

    private suspend fun removeFromFavorites() {
        val res = Firebase.firestore
            .collection(FirestorePath.USERS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .collection(FirestorePath.FAVORITES.path)
            .document(getCastle().id)
            .delete()
            .await()

        isInFavorites = false
    }

    private suspend fun loadIsReviewPresent() {
        val res = Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .document(getCastle().id)
            .collection(FirestorePath.REVIEWS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .get()
            .await()

        isReviewPresent = res.exists()
    }

    fun onLikeButtonClick() {
        viewModelScope.launch {
            onLikeButtonClickSusp()
        }
    }

    private suspend fun onLikeButtonClickSusp() {
        if (isInFavorites) {
            removeFromFavorites()
        } else {
            addToFavorites()
        }
    }

    private suspend fun loadImages() {
        val images = mutableListOf<String>()

        val res = Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .document(getCastle().id)
            .collection(FirestorePath.IMAGES.path)
            .get()
            .await()

        val docs = res.documents
        for (doc in docs) {
            val url = doc.getString("url")
            images.add(url!!)
        }

        this.images = images
    }

    private suspend fun loadReviews() {
        val reviews = mutableListOf<Review>()

        val res = Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .document(getCastle().id)
            .collection(FirestorePath.REVIEWS.path)
            .get()
            .await()

        val docs = res.documents
        for (doc in docs) {
            val review = doc.toObject<Review>()
            reviews.add(review!!)
        }

        this.reviews = reviews
    }

    fun addReview() {
        viewModelScope.launch {
            addReviewSusp()
        }
    }

    private suspend fun addReviewSusp() {
        val user = SharedData.user!!
        val userName = user.firstName + " " + user.secondName

        val userReview = hashMapOf(
            "rate" to getRate(),
            "comment" to comment,
            "userName" to userName
        )

        Firebase.firestore
            .collection(FirestorePath.CASTLES.path)
            .document(getCastle().id)
            .collection(FirestorePath.REVIEWS.path)
            .document(Firebase.auth.currentUser!!.uid)
            .set(userReview)
            .await()

        isReviewPresent = true
        reviews = reviews + Review(getRate(), comment, userName)
    }

}