package com.bsuir.castles.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.model.User
import com.bsuir.castles.view.help.BottomBar
import com.bsuir.castles.viewmodel.ProfileScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun ProfileScreen() {
    val viewModel = viewModel<ProfileScreenViewModel>()

    val user = viewModel.user

    Scaffold(
        bottomBar = {
            BottomBar()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = user.secondName + " " + user.firstName,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Text(
                text = user.email,
                fontSize = 18.sp,
                modifier = Modifier
                    .drawBehind {
                        drawRoundRect(
                            Color(0x100000FF),
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }
                    .padding(4.dp)

            )

            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp)
            )

            Text(
                text = "Bio: ${viewModel.user.bio}",
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp),
            )

            Text(
                text = "Birthdate: ${viewModel.getDateString()}",
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 10.dp)
            )

            Button(
                onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        viewModel.logout()
                    }
                },
                colors = ButtonColors(
                    Color(236, 42, 49, 255),
                    Color.White,
                    Color.Gray,
                    Color.LightGray
                )
            ) {
                Text(text = "Logout")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val viewModel = viewModel<ProfileScreenViewModel>()

    viewModel.user = User(
        "tishalovichm@gmail.com",
        "Maxim",
        "Tishalovich",
        "Some bio",
        Date()
    )

    ProfileScreen()
}
