package com.bsuir.castles.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bsuir.castles.R
import com.bsuir.castles.model.Castle
import com.bsuir.castles.view.help.ReviewForm
import com.bsuir.castles.view.help.Reviews
import com.bsuir.castles.viewmodel.CastleViewModel
import com.bsuir.castles.viewmodel.SharedData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CastleScreen() {
    val viewModel = viewModel<CastleViewModel>()

    val castle = viewModel.getCastle()

    LaunchedEffect(Unit) {
        viewModel.loadCastleInfo()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = castle.name,
            fontSize = 26.sp,
        )

        val pagerState = rememberPagerState(pageCount = {
            viewModel.images.size
        })

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(300.dp)
        ) { it ->
            AsyncImage(
                model = viewModel.images[it],
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxSize()
                    .clickable {
                    },
                contentDescription = "Image",
                placeholder = painterResource(id = R.drawable.disnep)
            )
        }

        Text(
            text = "Country: ${castle.country}",
            fontSize = 20.sp,
        )

        Text(
            text = "Foundation year: ${castle.foundationYear}",
            fontSize = 20.sp,
        )

        Icon(
            viewModel.icon,
            contentDescription = "Like",
            tint = Color.Red,
            modifier = Modifier
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.onLikeButtonClick()
                    }
                }
        )

        if (!viewModel.isReviewPresent) {
            ReviewForm(viewModel)
        }

        Reviews(viewModel)
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

    SharedData.castle = castle1

    CastleScreen()
}
