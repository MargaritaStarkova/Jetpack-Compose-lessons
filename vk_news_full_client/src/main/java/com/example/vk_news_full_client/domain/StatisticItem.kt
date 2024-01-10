package com.example.vk_news_full_client.domain

data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0,
)

enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}