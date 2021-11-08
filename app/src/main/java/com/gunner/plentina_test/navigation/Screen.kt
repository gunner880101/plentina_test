package com.gunner.plentina_test.navigation

/**
Created by GUNNER on 2021-11-07 17:19

 */

sealed class Screen(val route: String) {
    object MatchList : Screen("list")
    object MatchDetail : Screen("detail")
}

