package com.momiouo.naturequiz.ui.navigation

sealed class Screen(val route: String) {
    data object MenuScreen : Screen("MenuScreen")
    data object LoadingScreen : Screen("LoadingScreen")
    data object LevelScreen : Screen("LoadingScreen")
    data object QuestionScreen : Screen("QuestionScreen")
    data object EndScreen : Screen("EndScreen")
}