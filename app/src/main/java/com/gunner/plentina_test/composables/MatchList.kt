package com.gunner.plentina_test.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.gunner.plentina_test.models.MatchInfo

/**
Created by GUNNER on 2021-11-05 19:29

 */

@Composable
fun MatchList(matchList: List<MatchInfo>, navController: NavController) {
    LazyColumn {
        itemsIndexed(items = matchList) { _, item ->
            MatchCard(matchInfo = item, navController = navController)
        }
    }
}