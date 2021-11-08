package com.gunner.plentina_test.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchInfo(
    val title: String,
    val competition: String,
    val thumbnail: String,
    val date: String,
) : Parcelable
