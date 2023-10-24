package com.example.meditation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.meditation.Screen
import com.example.meditation.utils.Constant.INDEX_KEY

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route + "/{$INDEX_KEY}",
            arguments = listOf(
                navArgument(INDEX_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )

        ) { entry ->

            DetailScreen(navController = navController, id = entry.arguments?.getInt(INDEX_KEY))

        }
    }
}