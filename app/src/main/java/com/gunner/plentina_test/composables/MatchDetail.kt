package com.gunner.plentina_test.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gunner.plentina_test.models.MatchInfo

/**
Created by GUNNER on 2021-11-07 17:15

 */

@Composable
fun MatchDetail(matchInfo: String?) {
    Column() {
        matchInfo?.let { Text(text = it, modifier = Modifier.fillMaxSize()) }
    }
}