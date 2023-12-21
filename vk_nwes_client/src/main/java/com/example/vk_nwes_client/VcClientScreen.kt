package com.example.vk_nwes_client

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagram_box.R
import com.example.vk_nwes_client.theme.MyApplicationTheme

@Composable
fun PostCard() {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 2.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
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
                    modifier = Modifier
                )
            }
            Text(
                text = stringResource(id = R.string.text),
                modifier = Modifier.padding(8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                alignment = Alignment.Center
            )

            Row {
                Text(text = "206")
                Image(
                    painter = painterResource(id = R.drawable.ic_views_count),
                    contentDescription = null,
                )

                Text(text = "206")
                Image(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = null,
                )

                Text(text = "11")
                Image(
                    painter = painterResource(id = R.drawable.ic_comment),
                    contentDescription = null,
                )

                Text(text = "491")
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview()
@Composable
fun PreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        PostCard()
    }
}

