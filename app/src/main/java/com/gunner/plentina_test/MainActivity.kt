package com.gunner.plentina_test

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.gunner.plentina_test.comonents.MatchCard
import com.gunner.plentina_test.models.MatchInfo

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatchCard(
                MatchInfo(
                    title = "AC Milan - Porto",
                    competition = "CHAMPIONS LEAGUE: Group stage, Group B",
                    matchViewUrl = "https://www.scorebat.com/embed/matchview/1122520/",
                    competitionUrl = "https://www.scorebat.com/embed/competition/champions-league-group-stage-group-b/",
                    thumbnail = "https://www.scorebat.com/og/m/og1122520.jpeg",
                    date = strToDateTime("2021-11-03T17:45:00+0000"),
                    videos = ""
                )

            )
        }
    }
}
