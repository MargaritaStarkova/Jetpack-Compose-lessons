package com.example.vk_news_main_screen

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.instagram_box.R
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    val snackbarHostState = SnackbarHostState()
    Log.d("MyLog", "Recomposition")
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember {
        mutableStateOf(true)
    }


    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, floatingActionButton = {
        if (fabIsVisible.value) {
            FloatingActionButton(onClick = {
                scope.launch {
                    val action = snackbarHostState.showSnackbar(
                        message = "This is snackbar",
                        actionLabel = "Hide FAB",
                        duration = SnackbarDuration.Long
                    )

                    if (action == SnackbarResult.ActionPerformed) {
                        fabIsVisible.value = false
                    }
                }
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }
    }, bottomBar = {
        BottomNavigation {
            Log.d("MyLog", "BottomNavigation: 1")
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
        Text(
            modifier = Modifier.padding(it), text = "This is scaffold content"
        )
    })
}