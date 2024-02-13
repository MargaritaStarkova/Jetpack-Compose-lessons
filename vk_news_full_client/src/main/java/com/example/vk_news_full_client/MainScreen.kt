package com.example.vk_news_full_client

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vk_news_full_client.domain.FeedPost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val snackbarHostState = SnackbarHostState()

    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, bottomBar = {
        BottomNavigation {
            val selectedItemPosition = remember {
                mutableIntStateOf(0)
            }
            val items =
                listOf(NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile)

            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    selected = selectedItemPosition.intValue == index,
                    onClick = { selectedItemPosition.intValue = index },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(text = stringResource(id = item.titleResId)) },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = MaterialTheme.colors.onSecondary,
                )
            }
        }
    }, content = {
        val feedPost = viewModel.feedState.observeAsState(FeedPost())

        PostCard(modifier = Modifier.padding(8.dp),
            feedPost = feedPost.value ,
            onViewsItemClicked = viewModel::updateCount,
            onShareItemClicked = viewModel::updateCount,
            onCommentsItemClicked = viewModel::updateCount,
            onLikesItemClicked = viewModel::updateCount,
        )
    })
}