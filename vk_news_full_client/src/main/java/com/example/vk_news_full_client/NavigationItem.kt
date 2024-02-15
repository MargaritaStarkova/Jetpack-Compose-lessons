package com.example.vk_news_full_client

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.instagram_box.R
import com.example.vk_news_full_client.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    @StringRes val titleResId: Int,
    val icon: ImageVector,
) {
    data object Home: NavigationItem(
        screen = Screen.NewsFeed,
        titleResId = R.string.main,
        icon = Icons.Outlined.Home
    )
    data object Favourite: NavigationItem(
        screen = Screen.Favourite,
        titleResId = R.string.favorite,
        icon = Icons.Outlined.Star
    )
    data object Profile: NavigationItem(
        screen = Screen.Profile,
        titleResId = R.string.profile,
        icon = Icons.Outlined.Face
    )
}