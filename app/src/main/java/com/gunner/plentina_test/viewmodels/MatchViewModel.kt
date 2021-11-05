package com.gunner.plentina_test.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gunner.plentina_test.models.MatchInfo
import com.gunner.plentina_test.services.ApiService
import kotlinx.coroutines.launch

/**
Created by GUNNER on 2021-11-05 18:45

 */
class MatchViewModel: ViewModel() {
    var matchListResponse:List<MatchInfo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMatchList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val matchList = apiService.fetchMatchInfoList()
                matchListResponse = matchList.response
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}