package com.gunner.plentina_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.gunner.plentina_test.navigation.Navigation
import com.gunner.plentina_test.ui.theme.Plentina_testTheme
import com.gunner.plentina_test.viewmodels.MatchViewModel

class MainActivity : ComponentActivity() {
    private val matchViewModel by viewModels<MatchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Plentina_testTheme() {
                Surface(color = MaterialTheme.colors.background){
                    Navigation(matchViewModel)
                }
            }
        }
    }
}
