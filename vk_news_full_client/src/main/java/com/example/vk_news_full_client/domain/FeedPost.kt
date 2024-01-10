package com.example.vk_news_full_client.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.instagram_box.R

data class FeedPost(
    val communityName: String = "уволено",
    val publicationDate: String = "14:00",
    @DrawableRes val avatarResId: Int = R.drawable.post_comunity_thrumbnail,
    @StringRes val contentText: Int = R.string.text,
    @DrawableRes val contentImageResId: Int = R.drawable.post_content_image,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, count = 966),
        StatisticItem(type = StatisticType.SHARES, count = 7),
        StatisticItem(type = StatisticType.COMMENTS, count = 8),
        StatisticItem(type = StatisticType.LIKES, count = 27)

    )
)
