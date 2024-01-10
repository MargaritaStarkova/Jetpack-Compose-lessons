package com.example.vk_news_full_client

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.instagram_box.R
import com.example.vk_news_full_client.domain.FeedPost
import com.example.vk_news_full_client.domain.StatisticItem
import com.example.vk_news_full_client.domain.StatisticType
import java.lang.IllegalArgumentException

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onStatisticsItemClicked: (StatisticItem) -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = feedPost.contentText))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = feedPost.contentImageResId),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(
                statistics = feedPost.statistics,
                onItemClicked = onStatisticsItemClicked
            )
        }
    }
}

@Composable
private fun PostHeader(
    feedPost: FeedPost,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = feedPost.communityName, color = MaterialTheme.colors.onPrimary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = feedPost.publicationDate, color = MaterialTheme.colors.onSecondary)
        }

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
    onItemClicked: (StatisticItem) -> Unit,
) {
    Row {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(
                icon = R.drawable.ic_views_count,
                text = viewsItem.count.toString(),
                onIconClicked = { onItemClicked(viewsItem) }
            )
        }
        Row(
            modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithText(
                icon = R.drawable.ic_share,
                text = sharesItem.count.toString(),
                onIconClicked = { onItemClicked(sharesItem) }
            )

            val commentsItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(
                icon = R.drawable.ic_comment,
                text = commentsItem.count.toString(),
                onIconClicked = { onItemClicked(commentsItem) }
            )

            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(
                icon = R.drawable.ic_like,
                text = likesItem.count.toString(),
                onIconClicked = { onItemClicked(likesItem) }
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalArgumentException()
}

@Composable
private fun IconWithText(
    @DrawableRes icon: Int,
    text: String,
    onIconClicked: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(onClick = onIconClicked, indication = rememberRipple(bounded = false), interactionSource = remember { MutableInteractionSource() })
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text, color = MaterialTheme.colors.onSecondary)
    }
}

