package com.bsuir.castles.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsuir.castles.model.User
import com.bsuir.castles.viewmodel.ProfileScreenViewModel
import java.util.Date

@Composable
fun ProfileScreen() {
    val viewModel = viewModel<ProfileScreenViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(text = "Email: ${viewModel.user.email}")
        Text(text = "First name: ${viewModel.user.firstName}")
        Text(text = "Last name: ${viewModel.user.secondName}")
        Text(text = "Bio: ${viewModel.user.bio}")
        Text(text = "Birthdate: ${viewModel.user.birthdate}")

        Button(
            onClick = {
                ////logOut()
                //navController.navigate(Screen.Login.name) {
                //    navController.clearBackStack(Screen.Castles.name)
                //    navController.clearBackStack(Screen.Castle.name)
                //    navController.clearBackStack(Screen.Favorite.name)
                //    navController.clearBackStack(Screen.Profile.name)
                //}
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
