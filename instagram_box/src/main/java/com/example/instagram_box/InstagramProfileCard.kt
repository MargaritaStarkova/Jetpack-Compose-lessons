package com.example.instagram_box

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_box.theme.MyApplicationTheme


@Composable
fun InstaBox() {

    Card(
        modifier = Modifier.padding(8.dp),
        backgroundColor = MaterialTheme.colors.background,
        shape = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp
        ),

        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)

        ) {
            Box(
                modifier = Modifier
                    .border(1.dp, color = MaterialTheme.colors.onBackground)
                    .background(Color.Cyan)
                    .size(50.dp)
            )

            UserStatistic(value = "6,950", header = "Posts")
            UserStatistic(value = "436M", header = "Followers")
            UserStatistic(value = "76", header = "Following")
        }
    }

}

@Composable
private fun UserStatistic(
    header: String,
    value: String,
    ) {
    Column(
        modifier = Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive,
           // color = MaterialTheme.colors.onBackground,
        )

        Text(
            text = header,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
          //  color = MaterialTheme.colors.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserStatisticPreview() {
    UserStatistic(header = "6,950", value = "Posts")
}

@Preview
@Composable
fun CardLight() {
    MyApplicationTheme(
        darkTheme = false
    ) {
        InstaBox()
    }

}

@Preview
@Composable
fun CardDark() {
    MyApplicationTheme(
        darkTheme = true
    ) {
        InstaBox()
    }
}


