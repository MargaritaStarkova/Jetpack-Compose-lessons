package com.example.vk_news_full_client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vk_news_full_client.domain.FeedPost
import com.example.vk_news_full_client.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val _feedState = MutableLiveData(FeedPost())
    val feedState: LiveData<FeedPost> = _feedState

    fun updateCount(item: StatisticItem) {
        val oldStatistics = _feedState.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }

        _feedState.value = _feedState.value?.copy(statistics = newStatistics)
    }
}