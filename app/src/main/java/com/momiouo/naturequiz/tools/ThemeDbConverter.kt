package com.momiouo.naturequiz.tools

import android.util.Log

class ThemeDbConverter {

    companion object {
        //TODO à convertir en id ...
        fun fromUiThemeToDBTheme(uiTheme: String): String? {
            Log.d("ThemeDbConverter", "fromUiThemeToDBTheme() called with: uiTheme = $uiTheme")
            return when (uiTheme) {
                "Bases" -> "Lesbases"
                "Basics" -> "Lesbases"
                "Chiffres Clés" -> "Chiffre"
                "Key Data" -> "Chiffre"
                "Animaux" -> "Animaux"
                "Animals" -> "Animaux"
                "Tops News" -> "topnews"
                "Tri et Décomposition" -> "Decomposition"
                "Sort And Decomposition" -> "Decomposition"
                "Digital" -> "digital"
                "Climate Change" -> "climatechange"
                "Changement Climatique" -> "climatechange"
                else -> null
            }

        }
    }
}