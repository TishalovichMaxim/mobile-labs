package com.bsuir.castles.viewmodel

import androidx.navigation.NavHostController

class Router {

    companion object {
        val instance = Router()
    }

    var navController: NavHostController? = null

    fun route(screen: Screen) {
        navController?.navigate(screen.name) {
        }
    }

}