package com.bsuir.castles.viewmodel

import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.Castle

class CastlesViewModel : ViewModel() {

    private var castles: List<Castle>? = null

    fun setCastles(castles: List<Castle> ) {
        this.castles = castles
    }

    fun getCastles() : List<Castle> {
        return castles!!
    }

}