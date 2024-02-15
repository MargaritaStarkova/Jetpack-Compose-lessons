package com.example.vk_news_full_client

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FixedThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val models = viewModel.model.observeAsState(listOf())


    LazyColumn(
        modifier = androidx.compose.ui.Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = models.value,
            key = { it.id }
        ) { model ->
            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                viewModel.delete(model)
            }

            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(),
                state = dismissState,
                directions = setOf(
                    DismissDirection.EndToStart,
                ),
                dismissThresholds = {
                    FixedThreshold(200.dp)
                },
                background = {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color.Red.copy(alpha = 0.5f))
                            .fillMaxSize(),
                        contentAlignment = Alignment.CenterEnd,
                    ) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Delete item",
                            color = Color.White,
                            fontSize = 24.sp,
                        )
                    }
                })
            {

                PostCard(
                    feedPost = model,
                    onViewsItemClicked = { viewModel.updateCount(model, it) },
                    onShareItemClicked = { viewModel.updateCount(model, it) },
                    onCommentsItemClicked = { viewModel.updateCount(model, it) },
                    onLikesItemClicked = { viewModel.updateCount(model, it) },
                )

            }
        }
    }
}