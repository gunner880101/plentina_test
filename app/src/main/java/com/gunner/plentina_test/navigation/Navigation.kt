package com.gunner.plentina_test.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.gunner.plentina_test.composables.MatchDetail
import com.gunner.plentina_test.composables.MatchList
import com.gunner.plentina_test.models.MatchInfo
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
                navArgument("matchInfo") {
                    type = AssetParamType()
                }
            )
        ) { entry ->
            val info = entry.arguments?.getParcelable<MatchInfo>("matchInfo")
            MatchDetail(matchInfo = info)
        }
    }
}

class AssetParamType : NavType<MatchInfo>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): MatchInfo? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): MatchInfo {
        return Gson().fromJson(value, MatchInfo::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: MatchInfo) {
        bundle.putParcelable(key, value)
    }
}