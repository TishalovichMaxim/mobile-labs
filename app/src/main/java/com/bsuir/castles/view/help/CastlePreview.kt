package com.bsuir.castles.view.help

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bsuir.castles.R
import com.bsuir.castles.model.Castle
import com.bsuir.castles.viewmodel.CastlesViewModel

@Composable
fun CastlePreview(castle: Castle) {
    val viewModel = viewModel<CastlesViewModel>()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                viewModel.goToCastle(castle)
            }
    ) {
        AsyncImage(
            model = castle.mainImage,
            contentDescription = "Castle image",
            placeholder = painterResource(id = R.drawable.disnep),
        )
        Text(text = castle.name)
    }
}

@Preview(showBackground = true)
@Composable
fun CastlePreviewPreview() {
    val castle = Castle(
        "some_id",
        "My Castle Name",
        "Belarus",
        1234,
        "some_image.jpg"
    )
    
    //CastlePreview(castle = castle)
}