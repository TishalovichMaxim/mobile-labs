package com.bsuir.castles.viewmodel.help

import androidx.navigation.NavHostController

class Router {

    companion object {
        val instance = Router()
    }

    var navController: NavHostController? = null

    fun route(screen: Screen) {
        navController?.navigate(screen.name) {
            if (screen != Screen.Castle) {
                navController!!.popBackStack()
            }
        }
    }

}