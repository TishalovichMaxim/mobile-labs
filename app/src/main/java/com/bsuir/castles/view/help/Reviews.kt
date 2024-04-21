package com.bsuir.castles.view.help

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.castles.model.Review
import com.bsuir.castles.viewmodel.CastleViewModel

@Composable
internal fun ReviewItem(review: Review) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(2.dp, Color.Black)
            .fillMaxWidth(0.8f)
            .padding(5.dp)
            .padding(top = 5.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            Text(
                text = review.userName,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = review.rate.toString(),
                color = Color.Red
            )
        }
        Text(text = review.comment)
    }
}

@Composable
fun Reviews(viewModel: CastleViewModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 7.dp)
    ) {
        Text(
            "Reviews",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier
                .padding(3.dp)
        )

        viewModel.reviews.forEach { review ->
            ReviewItem(review = review)
            Spacer(
                modifier = Modifier
                    .padding(7.dp)
            )
        }
    }
}