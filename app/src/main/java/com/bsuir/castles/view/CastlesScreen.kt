package com.bsuir.castles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.model.Castle
import com.bsuir.castles.view.help.CastlesList
import com.bsuir.castles.viewmodel.CastlesViewModel

@Composable
fun CastlesScreen() {

    val viewModel = viewModel<CastlesViewModel>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Castles of the world",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 15.dp)
        )

        CastlesList(castles = viewModel.getCastles())
    }

}

@Preview(showBackground = true)
@Composable
fun CastlesScreenPreview() {
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
    val castles = listOf<Castle>(castle1, castle2, castle3, castle4)

    val viewModel = viewModel<CastlesViewModel>()
    viewModel.setCastles(castles)

    CastlesScreen()
}
