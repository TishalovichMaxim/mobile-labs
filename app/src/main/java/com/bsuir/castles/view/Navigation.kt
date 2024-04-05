package com.bsuir.castles.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsuir.castles.viewmodel.Router
import com.bsuir.castles.viewmodel.Screen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    Router.instance.navController = navController

    NavHost(navController = navController, startDestination = Screen.SignUp.name) {
        composable(route = Screen.SignUp.name) {
            SignUpScreen()
        }
        composable(route = Screen.SignIn.name) {
            SignInScreen()
        }
    }

}