package com.bsuir.castles.view.help

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsuir.castles.model.Castle

@Composable
fun CastlesList(castles: List<Castle>) {
    Column {
        castles.forEach() {
            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            CastlePreview(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CastlesListPreview() {
    val castle1 = Castle(
        "someid",
        "Mir Castle",
        "Belarus",
        2124,
        "some_image.png"
    )

    val castle2 = Castle(
        "someid",
        "Disnep Castle",
        "Belarus",
        2124,
        "some_image.png"
    )

    val castle3 = Castle(
        "someid",
        "Mir Castle",
        "Belarus",
        2124,
        "some_image.png"
    )

    val castle4 = Castle(
        "someid",
        "Disnep Castle",
        "Belarus",
        2124,
        "some_image.png"
    )

    val castles = mutableListOf(castle1, castle2, castle3, castle4)

    CastlesList(castles = castles)
}
