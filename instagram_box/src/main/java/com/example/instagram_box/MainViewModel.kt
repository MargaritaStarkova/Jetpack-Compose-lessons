package com.example.instagram_box

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class MainViewModel : ViewModel() {

        private val initialList = mutableListOf<InstagramModel>().apply {
            repeat(500) {
                add(
                    InstagramModel(
                        id = it,
                        title = "Title: #$it",
                        isFollowing = Random.nextBoolean()
                    )
                )
            }
        }
    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val model: LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(model: InstagramModel) {
        val modifiedList = _models.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (it == model) {
                it.copy(isFollowing = !it.isFollowing)
            } else {
                it
            }
        }

        _models.value = modifiedList
    }
}