package com.bsuir.castles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.bsuir.castles.viewmodel.CastlesViewModel

@Composable
fun CastlesScreen() {
    val viewModel = viewModel<CastlesViewModel>()

    LaunchedEffect(Unit) {
        viewModel.loadCastles()
    }

    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "Castles of the world",
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

            CastlesList(viewModel.getAllCastles())
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CastlesScreenPreview() {
    CastlesScreen()
}
