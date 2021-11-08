package com.gunner.plentina_test.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.gunner.plentina_test.R
import com.gunner.plentina_test.models.MatchInfo
import com.gunner.plentina_test.utils.fontFamily
import com.gunner.plentina_test.utils.strToDateTime

/**
Created by GUNNER on 2021-11-07 17:15

 */

@Composable
fun MatchDetail(matchInfo: MatchInfo?) {
    val teams = matchInfo!!.title.split("-")
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberImagePainter(
                data = matchInfo.thumbnail,
                builder = {
                    scale(Scale.FILL)
                    placeholder(R.drawable.placeholder_image)
                }),

            contentDescription = null,

            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = matchInfo.competition, fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = matchInfo.title, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = strToDateTime(matchInfo.date),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = fontFamily,
            color = Color.DarkGray
        )
    }
}