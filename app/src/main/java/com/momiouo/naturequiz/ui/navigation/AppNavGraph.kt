package com.momiouo.naturequiz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.momiouo.naturequiz.ui.screens.LevelScreen
import com.momiouo.naturequiz.ui.screens.LoadingScreen
import com.momiouo.naturequiz.ui.screens.MenuScreen
import com.momiouo.naturequiz.ui.screens.QuestionScreen


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoadingScreen.route) {
        composable(Screen.LoadingScreen.route) {
            LoadingScreen(navigateToMenuScreen = {
                navController.navigate(
                    route = Screen.MenuScreen.route,
                    navOptions = NavOptions.Builder().setPopUpTo(Screen.LoadingScreen.route, false)
                        .build()
                )
            })
        }

        composable(Screen.MenuScreen.route) {
            MenuScreen(
                navigateToLevelScreen = { navController.navigate(Screen.LevelScreen.route) }
            )
        }

        composable(
            route = Screen.LevelScreen.route + "{themeId}",
            arguments = listOf(navArgument("themeId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val themeId = backStackEntry.arguments?.getString("themeId")
            LevelScreen(themeId)
        }

        composable(Screen.QuestionScreen.route) {
            QuestionScreen()
        }
    }
}