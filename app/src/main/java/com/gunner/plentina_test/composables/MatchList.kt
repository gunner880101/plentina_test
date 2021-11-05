package com.gunner.plentina_test.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import com.gunner.plentina_test.models.MatchInfo

/**
Created by GUNNER on 2021-11-05 19:29

 */

@Composable
fun MatchList(matchList: List<MatchInfo>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(items = matchList) { index, item ->
            MatchCard(matchInfo = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }
}