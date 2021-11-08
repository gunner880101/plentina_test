package com.gunner.plentina_test.navigation

import com.gunner.plentina_test.models.MatchInfo

/**
Created by GUNNER on 2021-11-07 17:19

 */

sealed class Screen(val route: String) {
    object MatchList : Screen("list")
    object MatchDetail : Screen("detail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

