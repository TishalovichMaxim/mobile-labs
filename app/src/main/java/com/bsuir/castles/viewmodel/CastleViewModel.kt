package com.bsuir.castles.viewmodel

import androidx.lifecycle.ViewModel
import com.bsuir.castles.model.Castle

class CastleViewModel : ViewModel() {

    private var castle: Castle? = null

    fun setCastle(castle: Castle) {
        this.castle = castle
    }

    fun getCastle(): Castle {
        return castle!!
    }
}