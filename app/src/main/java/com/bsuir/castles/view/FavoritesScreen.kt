package com.bsuir.castles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.view.help.BottomBar
import com.bsuir.castles.view.help.CastlesList
import com.bsuir.castles.viewmodel.FavoritesScreenViewModel

@Composable
fun FavoritesScreen() {
    val viewModel = viewModel<FavoritesScreenViewModel>()

    LaunchedEffect(Unit) {
        viewModel.loadFavorites()
    }

    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Favorites",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 15.dp)
            )

            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )

            TextField(
                value = viewModel.searchText,
                onValueChange = {
                    viewModel.searchText = it
                },
                modifier = Modifier
            )

            Spacer(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )

            CastlesList(viewModel.getAllFavorites())
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
}
