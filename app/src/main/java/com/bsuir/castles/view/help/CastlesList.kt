package com.bsuir.castles.view.help

import androidx.compose.runtime.Composable
import com.bsuir.castles.model.Castle

@Composable
fun CastlesList(castles: List<Castle>) {
    castles.forEach() {
        CastlePreview(castle = it)
    }
}