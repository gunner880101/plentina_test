package com.gunner.plentina_test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gunner.plentina_test.composables.MatchDetail
import com.gunner.plentina_test.composables.MatchList
import com.gunner.plentina_test.viewmodels.MatchViewModel

/**
Created by GUNNER on 2021-11-07 17:18

 */

@Composable
fun Navigation(matchViewModel: MatchViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MatchList.route) {
        composable(route = Screen.MatchList.route) {
            MatchList(matchList = matchViewModel.matchListResponse, navController = navController)
            matchViewModel.getMatchList()
        }
        composable(
            route = Screen.MatchDetail.route + "/{matchInfo}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "World"
                    nullable = true
                }
            )
        ) { entry ->
            MatchDetail(matchInfo = entry.arguments?.getString("matchInfo"))
        }
    }
}