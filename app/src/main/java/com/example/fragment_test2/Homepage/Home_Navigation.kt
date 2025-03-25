package com.example.fragment_test2.Homepage

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String){
    object Home : Screen("home_screen")
    object Search : Screen("Search_screen")
    object Result : Screen("result_screen")

}

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomePageContent(navController)
        }
        composable(Screen.Search.route) {
            SearchPage(navController)
        }
        composable(Screen.Result.route) {
            ResultPage(navController)
        }


    }
}
