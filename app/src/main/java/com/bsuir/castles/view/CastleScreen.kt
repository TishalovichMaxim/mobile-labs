package com.bsuir.castles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bsuir.castles.R
import com.bsuir.castles.model.Castle
import com.bsuir.castles.viewmodel.CastleViewModel

@Composable
fun CastleScreen() {

    val castle1 = Castle(
        "someid",
        "Another",
        "Belarus",
        2124,
        "https://upload.wikimedia.org/wikipedia/commons/d/d6/%D0%9A%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%81_%D0%9C%D0%B8%D1%80%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%B7%D0%B0%D0%BC%D0%BA%D0%B0.JPG"
    )

    val viewModel = viewModel<CastleViewModel>()

    viewModel.setCastle(castle1)

    val castle = viewModel.getCastle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = castle.name,
            fontSize = 26.sp,
        )

        AsyncImage(
            model = castle.mainImage,
            contentDescription = "Castle photo",
            placeholder = painterResource(R.drawable.disnep)
        )

        Text(
            text = "Country: ${castle.country}",
            fontSize = 20.sp,
        )
        Text(
            text = "Foundation year: ${castle.foundationYear}",
            fontSize = 20.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CastleScreenPreview() {
    val castle1 = Castle(
        "someid",
        "Another",
        "Belarus",
       2124,
        "https://upload.wikimedia.org/wikipedia/commons/d/d6/%D0%9A%D0%BE%D0%BC%D0%BF%D0%BB%D0%B5%D0%BA%D1%81_%D0%9C%D0%B8%D1%80%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_%D0%B7%D0%B0%D0%BC%D0%BA%D0%B0.JPG"
    )

    val viewModel = viewModel<CastleViewModel>()
    viewModel.setCastle(castle1)

    CastleScreen()
}
