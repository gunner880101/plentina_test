package com.gunner.plentina_test.composables

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.google.gson.Gson
import com.gunner.plentina_test.R
import com.gunner.plentina_test.models.MatchInfo
import com.gunner.plentina_test.navigation.Screen
import com.gunner.plentina_test.utils.fontFamily
import com.gunner.plentina_test.utils.strToDateTime

@ExperimentalCoilApi
@Composable
fun MatchCard(
    matchInfo: MatchInfo,
    navController: NavController,
) {

    val teams = matchInfo.title.split("-")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(4.dp)
            .clickable {
                val json = Uri.encode(Gson().toJson(matchInfo))
                navController.navigate(Screen.MatchDetail.route + "/$json")
            },
        elevation = 2.dp,
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
                        .weight(2f),
                    verticalArrangement = Arrangement.SpaceAround

                ) {
                    Text(
                        matchInfo.competition,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamily,
                        color = Color.DarkGray
                    )
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.versus),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp, 0.dp))
                        Column() {
                            Text(
                                teams[0].trim(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                fontFamily = fontFamily
                            )
                            Text(
                                teams[1].trim(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                fontFamily = fontFamily
                            )
                        }
                    }
                    Text(
                        strToDateTime(matchInfo.date),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        fontFamily = fontFamily
                    )
                }
                Image(
                    painter = rememberImagePainter(
                        data = matchInfo.thumbnail,
                        builder = {
                            scale(Scale.FIT)
                            placeholder(R.drawable.placeholder_image)
                        }),
                    contentDescription = null,

                    modifier = Modifier.clip(RoundedCornerShape(6.dp))
                )
            }
        }
    }
}