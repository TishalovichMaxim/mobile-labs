package com.bsuir.castles.view.help

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bsuir.castles.viewmodel.help.Router
import com.bsuir.castles.viewmodel.help.Screen

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Button(
            onClick = {
                Router.instance.route(Screen.Profile)
            }
        ) {
            Icon(
                Icons.Rounded.AccountCircle,
                contentDescription = "Profile"
            )
        }
        Button(
            onClick = {
                Router.instance.route(Screen.Castles)
            }
        ) {
            Icon(
                Icons.Rounded.Search,
                contentDescription = "Profile"
            )
        }
        Button(
            onClick = {
                Router.instance.route(Screen.Favorites)
            }
        ) {
            Icon(
                Icons.Rounded.Favorite,
                contentDescription = "Profile"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar()
}
