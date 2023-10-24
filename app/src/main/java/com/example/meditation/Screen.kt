package com.example.meditation

import com.example.meditation.utils.Constant.DETAIL_KEY
import com.example.meditation.utils.Constant.HOME_KEY

sealed class Screen(val route: String) {
    object Home : Screen(route = HOME_KEY)
    object Detail : Screen(route = DETAIL_KEY)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
