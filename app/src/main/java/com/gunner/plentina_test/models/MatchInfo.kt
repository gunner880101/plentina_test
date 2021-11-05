package com.gunner.plentina_test.models

data class MatchInfo(
    val title: String,
    val competition: String,
    val matchViewUrl: String,
    val competitionUrl: String,
    val thumbnail: String,
    val date: String,
    val videos: List<VideoInfo>,
)
