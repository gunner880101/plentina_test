package com.gunner.plentina_test.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.gunner.plentina_test.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
Created by GUNNER on 2021-11-05 16:18

 */

val fontFamily = FontFamily(
    Font(R.font.kanit_medium)
)

@RequiresApi(Build.VERSION_CODES.O)
fun strToDateTime(dateTme: String): String {
    val dt = LocalDateTime.parse(dateTme.substring(0, 19), DateTimeFormatter.ISO_DATE_TIME)

    return dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
}