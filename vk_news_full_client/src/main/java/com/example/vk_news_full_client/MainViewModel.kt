package com.example.vk_news_full_client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vk_news_full_client.domain.FeedPostModel
import com.example.vk_news_full_client.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<FeedPostModel>().apply {
        repeat(10) {
            add(
                FeedPostModel(
                    id = it
                )
            )
        }
    }

    private val _models = MutableLiveData<List<FeedPostModel>>(initialList)
    val model: LiveData<List<FeedPostModel>> = _models

    fun updateCount(feedPostModel: FeedPostModel, item: StatisticItem) {

        val oldPosts = _models.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = feedPostModel.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPostModel = feedPostModel.copy(statistics = newStatistics)
        _models.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPostModel.id) {
                    newFeedPostModel
                } else {
                    it
                }
            }
        }
    }

    fun delete(model: FeedPostModel) {
        val modifiedList = _models.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(model)
        _models.value = modifiedList
    }
}
