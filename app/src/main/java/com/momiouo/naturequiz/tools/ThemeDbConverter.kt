package com.momiouo.naturequiz.tools

import android.util.Log
import fr.momiouo.naturequiz.R

class ThemeDbConverter {

    companion object {
        fun fromUiThemeToDBTheme(uiTheme: String): String? {
            Log.d("ThemeDbConverter", "fromUiThemeToDBTheme() called with: uiTheme = $uiTheme")
            return when (uiTheme) {
                "1", "Bases", "Basics", "Lesbases" -> "Lesbases"
                "2", "Chiffres Clés", "Key Data", "Chiffre" -> "Chiffre"
                "3", "Animaux", "Animals" -> "Animaux"
                "4", "Tops News", "topnews" -> "topnews"
                "5", "Digital", "digital" -> "digital"
                "6", "Climate Change", "Changement Climatique", "climatechange" -> "climatechange"
                "7", "Tri et Décomposition", "Sort And Decomposition", "Decomposition" -> "Decomposition"
                "8", "Quiz IA", "AI Quiz", "Generate Your Quiz", "Générer votre Quiz", Const.AI_QUIZ_DB_THEME -> Const.AI_QUIZ_DB_THEME
                else -> null
            }
        }

        fun getThemeTitleRes(themeKey: String?): Int? {
            return when (themeKey) {
                "1", "Lesbases", "Bases", "Basics" -> R.string.les_bases
                "2", "Chiffre", "Chiffres Clés", "Key Data" -> R.string.les_chiffres_cl_s
                "3", "Animaux", "Animals" -> R.string.les_animaux
                "4", "topnews", "Tops News" -> R.string.les_tops_news
                "5", "digital", "Digital" -> R.string.digital
                "6", "climatechange", "Climate Change", "Changement Climatique" -> R.string.climate_change
                "7", "Decomposition", "Tri et Décomposition", "Sort And Decomposition" -> R.string.le_tri_et_la_d_composition
                "8", Const.AI_QUIZ_DB_THEME, "Quiz IA", "AI Quiz", "Generate Your Quiz", "Générer votre Quiz" -> R.string.ai_quiz_theme
                else -> null
            }
        }
    }
}