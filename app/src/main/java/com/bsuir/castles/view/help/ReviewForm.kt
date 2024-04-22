package com.bsuir.castles.view.help

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.bsuir.castles.viewmodel.CastleViewModel

@Composable
fun ReviewForm(viewModel: CastleViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Make your review")

        Slider(
            value = viewModel.sliderPosition,
            onValueChange = { viewModel.sliderPosition = it },
            steps = 9
        )

        Text(text = "Rate = ${viewModel.getRate()}")

        TextField(
            value = viewModel.comment,
            onValueChange = { viewModel.comment = it },
            minLines = 3
        )

        Button(
            onClick = {
                viewModel.addReview()
            }
        ) {
            Text(text = "Create")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ReviewFormPreview() {
    //ReviewForm()
}
