package com.momiouo.naturequiz.tools

import android.util.Log

class ThemeDbConverter {

    companion object {
        //TODO à convertir en id ...
        fun fromUiThemeToDBTheme(uiTheme: String): String? {
            Log.d("ThemeDbConverter", "fromUiThemeToDBTheme() called with: uiTheme = $uiTheme")
            return when (uiTheme) {
                "Les Bases" -> "Lesbases"
                "Random" -> "Random"
                "Les Chiffres Clés" -> "Chiffre"
                "Les Animaux" -> "Animaux"
                "Les Tops News" -> "topnews"
                "Le Tri et la Décomposition" -> "Decomposition"
                "Digital" -> "digital"
                "Climate Change" -> "climatechange"
                else -> null
            }

        }
    }
}