package com.gunner.plentina_test.comonents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gunner.plentina_test.fontFamily
import com.gunner.plentina_test.models.MatchInfo

@ExperimentalCoilApi
@Composable
fun MatchCard(
//    painter: Painter,
    matchInfo: MatchInfo
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        elevation = 2.dp
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f)
                ) {
                    Text(
                        matchInfo.competition,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamily,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        matchInfo.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        fontFamily = fontFamily
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        matchInfo.date,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        fontFamily = fontFamily
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(4.dp), shape = RoundedCornerShape(5.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(matchInfo.thumbnail),
                        contentDescription = null,
                        modifier = Modifier.size(128.dp)
                    )
                }
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(
//                                Color.Transparent,
//                                Color.Gray
//                            ),
//                            startY = 150f
//                        )
//                    )
//            )
        }
    }
}