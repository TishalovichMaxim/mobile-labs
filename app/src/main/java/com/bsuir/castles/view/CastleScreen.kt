package com.bsuir.castles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.model.Castle
import com.bsuir.castles.viewmodel.CastleViewModel

@Composable
fun CastleScreen() {

    val viewModel = viewModel<CastleViewModel>()

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
        "Aboba123",
        "Belarus",
       2124,
        "some_image.png"
    )

    val viewModel = viewModel<CastleViewModel>()
    viewModel.setCastle(castle1)

    CastleScreen()
}
