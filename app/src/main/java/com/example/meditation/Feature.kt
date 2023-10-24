package com.example.meditation

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color


data class Feature(
    val title: String,
    val description:String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val darkColor: Color
    )


