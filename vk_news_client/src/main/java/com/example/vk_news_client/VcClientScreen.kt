package com.example.vk_news_client

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagram_box.R
import com.example.vk_news_client.theme.MyApplicationTheme

@Composable
fun PostCard() {
    Card(
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.text),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics()
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.post_comunity_thrumbnail),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "уволено", color = MaterialTheme.colors.onPrimary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "14:00", color = MaterialTheme.colors.onSecondary)
        }

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun Statistics() {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(icon = R.drawable.ic_views_count, text = "206")
        }
        Row(
            modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconWithText(icon = R.drawable.ic_share, text = "206")
            IconWithText(icon = R.drawable.ic_comment, text = "11")
            IconWithText(icon = R.drawable.ic_like, text = "491")
        }
    }
}

@Composable
private fun IconWithText(
    @DrawableRes icon: Int,
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text, color = MaterialTheme.colors.onSecondary )
    }
}

@Preview()
@Composable
private fun PreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview()
@Composable
private fun PreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        PostCard()
    }
}

