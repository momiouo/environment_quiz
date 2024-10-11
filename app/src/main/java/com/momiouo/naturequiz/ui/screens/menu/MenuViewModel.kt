package com.momiouo.naturequiz.ui.screens.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.momiouo.naturequiz.R
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val menuItemList = listOf(
        ButtonTheme(
            1,
            R.string.les_bases,
            R.drawable.basicsbackground,
            10
        ),
        ButtonTheme(
            2,
            R.string.les_chiffres_cl_s,
            R.drawable.keydatabackground,
            25
        ),
        ButtonTheme(
            3,
            R.string.les_animaux,
            R.drawable.animalsbackground,
            10
        ),
        ButtonTheme(
            4,
            R.string.les_tops_news,
            R.drawable.topnewsbackground,
            10
        ),
        ButtonTheme(
            5,
            R.string.digital,
            R.drawable.digitalbackground,
            10
        ),
        ButtonTheme(
            6,
            R.string.climate_change,
            R.drawable.climatechangebackground,
            15
        ),
        ButtonTheme(
            7,
            R.string.le_tri_et_la_d_composition,
            R.drawable.sortingbackground,
            140
        )
    )
}

