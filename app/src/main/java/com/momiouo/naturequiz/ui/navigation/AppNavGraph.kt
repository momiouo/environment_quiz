package com.momiouo.naturequiz.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.momiouo.naturequiz.ui.screens.EndScreen
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
                    navOptions = NavOptions.Builder().setPopUpTo(Screen.LoadingScreen.route, true)
                        .build()
                )
            })
        }

        composable(Screen.MenuScreen.route) {
            MenuScreen(
                navigateToLevelScreen = { themeId ->
                    navController.navigate(
                        route = Screen.LevelScreen.route + "/$themeId"
                    )
                }
            )
        }

        composable(
            route = Screen.LevelScreen.route + "/{themeId}",
            arguments = listOf(navArgument("themeId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val themeId = backStackEntry.arguments?.getString("themeId")
            val initialPosition = 0
            LevelScreen(
                themeId = themeId,
                navigateToQuestion = { theme, level ->
                    Log.d("AppNavGraph", "AppNavHost() called with: theme = $theme, level = $level")
                    navController.navigate(
                        route = Screen.QuestionScreen.route + "/$theme&$level&$initialPosition",
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(Screen.MenuScreen.route, false)
                            .build()
                    )
                }
            )
        }

        composable(
            route = Screen.QuestionScreen.route + "/{themeId}&{levelId}&{positionId}",
            arguments = listOf(navArgument(
                "themeId"
            ) {
                type = NavType.StringType
            }, navArgument(
                "levelId"
            ) {
                type = NavType.StringType
            }, navArgument(
                "positionId"
            ) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val themeId = backStackEntry.arguments?.getString("themeId")
            val levelId = backStackEntry.arguments?.getString("levelId")
            val positionId = backStackEntry.arguments?.getInt("positionId")
            QuestionScreen(
                themeId,
                levelId,
                positionId,
                navigateToNextQuestion = { theme, level, position ->
                    Log.d(
                        "AppNavGraph",
                        "AppNavHost() called with: theme = $theme, level = $level, position = $position"
                    )
                    navController.navigate(
                        route = Screen.QuestionScreen.route + "/$theme&$level&$position",
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(Screen.MenuScreen.route, false)
                            .build()
                    )
                },
                navigateToEndScreen = {
                    navController.navigate(
                        route = Screen.EndScreen.route + "/$themeId&$levelId",
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(Screen.MenuScreen.route, false)
                            .build()
                    )
                }
            )
        }

        composable(
            route = Screen.EndScreen.route + "/{themeId}&{levelId}",
            arguments = listOf(
                navArgument("themeId") { type = NavType.StringType },
                navArgument("levelId") { type = NavType.StringType })
        ) { backStackEntry ->
            val themeId = backStackEntry.arguments?.getString("themeId")
            val levelId = backStackEntry.arguments?.getString("levelId")

            val initialPosition = 0

            EndScreen(
                theme = themeId ?: "",
                level = levelId ?: "",
                navigateToMenuScreen = {
                    navController.navigate(
                        route = Screen.MenuScreen.route,
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(Screen.MenuScreen.route, false)
                            .build()
                    )
                },
                navigateToQuestionScreen = { theme, level ->
                    navController.navigate(
                        route = Screen.QuestionScreen.route + "/$theme&$level&$initialPosition",
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(Screen.MenuScreen.route, false)
                            .build()
                    )
                }
            )
        }
    }
}