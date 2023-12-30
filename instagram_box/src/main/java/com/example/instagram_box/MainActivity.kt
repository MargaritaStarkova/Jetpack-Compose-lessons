package com.example.instagram_box

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.instagram_box.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    InstaBox(mainViewModel = viewModel)
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestImage() {
    Box(modifier = Modifier
        .size(200.dp)
        .background(Color.Cyan)

    ) {
        Image(
            painter = ColorPainter(color = Color.Yellow),
            contentDescription = "",
            modifier = Modifier
                .background(color = Color.Green)
                .padding(25.dp)
                .clip(shape = CircleShape)
                .size(100.dp)
                .background(color = Color.Red)
                .padding(25.dp),
        )
    }

}

//==================================================================================================

/*@Preview(showBackground = true)
@Composable
fun TestText() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Cursive
                )
            ) {
                append("Hello,")
            }

            append(" ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSynthesis = FontSynthesis.All,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
            ) {
                append("Rita")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Magenta
                )
            ) {
                append("!")
            }
        }
    )
}*/

//==================================================================================================

/*
@Preview(showBackground = true)
@Composable
fun TestText() {
    Text(
        text = "Hello, Rita!!!!",
        fontSize = 26.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Serif,
        textDecoration = TextDecoration.Underline
    )
}
*/

/*
@Preview(showBackground = true)
@Composable
fun CardTest() {
    Card(
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp,
        ),
        backgroundColor = Color.Magenta,
        contentColor = Color.LightGray,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Hello, World!",
        )

    }
}
*/
//==================================================================================================

