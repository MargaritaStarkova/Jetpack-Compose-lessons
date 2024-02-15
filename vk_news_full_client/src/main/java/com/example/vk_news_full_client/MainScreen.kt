package com.example.vk_news_full_client

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val snackbarHostState = SnackbarHostState()
    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)


    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, bottomBar = {
        BottomNavigation {
            val selectedItemPosition = remember {
                mutableIntStateOf(0)
            }
            val items =
                listOf(NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile)

            items.forEach { item ->
                BottomNavigationItem(
                    selected = selectedNavItem == item,
                    onClick = { viewModel.selectedNavItem(item) },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(text = stringResource(id = item.titleResId)) },
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = MaterialTheme.colors.onSecondary,
                )
            }
        }
    }) { paddingValues ->

        when (selectedNavItem) {
            NavigationItem.Home -> {
                HomeScreen(viewModel = viewModel, paddingValues = paddingValues)
            }

            NavigationItem.Favourite -> {
                TextCounter("NavigationItem.Favourite")
            }

            NavigationItem.Profile -> {
                TextCounter("NavigationItem.Profile")
            }
        }

    }
}

@Composable
fun TextCounter(
    name: String,
) {
    var count by remember {
        mutableIntStateOf(0)
    }

    Text(
        modifier = Modifier.clickable {
            count++
        },
        text = "$name count $count"
    )
}