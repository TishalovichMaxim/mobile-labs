package com.bsuir.castles.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsuir.castles.viewmodel.help.Router
import com.bsuir.castles.viewmodel.help.Screen

@Composable
fun Navigation(
) {
    val navController = rememberNavController()
    Router.instance.navController = navController

    NavHost(navController = navController, startDestination = Screen.SignIn.name) {

        composable(route = Screen.SignUp.name) {
            SignUpScreen()
        }
        composable(route = Screen.SignIn.name) {
            SignInScreen()
        }
        composable(route = Screen.Castle.name) {
            CastleScreen()
        }
        composable(route = Screen.Profile.name) {
            ProfileScreen()
        }
        composable(route = Screen.Castles.name) {
            CastlesScreen()
        }
        composable(route = Screen.Favorites.name) {
            FavoritesScreen()
        }
    }
}