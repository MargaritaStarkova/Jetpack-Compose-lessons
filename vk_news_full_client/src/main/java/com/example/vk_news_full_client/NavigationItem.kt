package com.example.vk_news_full_client

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.instagram_box.R

sealed class NavigationItem(
    @StringRes val titleResId: Int,
    val icon: ImageVector,
) {
    data object Home: NavigationItem(
        titleResId = R.string.main,
        icon = Icons.Outlined.Home
    )
    data object Favourite: NavigationItem(
        titleResId = R.string.favorite,
        icon = Icons.Outlined.Star
    )
    data object Profile: NavigationItem(
        titleResId = R.string.profile,
        icon = Icons.Outlined.Face
    )
}