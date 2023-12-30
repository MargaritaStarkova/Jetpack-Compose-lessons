package com.example.material_components

import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Test()
            }
        }
    }
}

@Composable
private fun Test() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
//            BottomAppBar {
//                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(Icons.Filled.Menu, contentDescription = null)
//                    }
//                }
//                Spacer(modifier = Modifier.weight(1f, true))
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(Icons.Filled.Favorite, contentDescription = null)
//                }
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(Icons.Filled.Favorite, contentDescription = null)
//                }
//            }

            val items = listOf("Songs", "Artists", "Playlists")
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(text = item) }
                    )
                }
            }
        },
        drawerContent = {
            ModalDrawer(
                drawerState = drawerState,
                drawerContent = {
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp),
                        onClick = { scope.launch { drawerState.close() } },
                        content = { Text(text = "Close Drawer") }
                    )
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = if (drawerState.isClosed) ">>> SWIPE >>>" else "<<< SWIPE <<<")
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = { scope.launch { drawerState.open() } }) {
                            Text(text = "Click to open")
                        }
                    }
                }
            )
        },
        content = {
            Text(
                modifier = Modifier.padding(it),
                text = "This is scaffold content"
            )
        },
    )
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "Hello, World!")
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = {},
        label = { Text(text = "Label") },
        singleLine = true,
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(text = "Are you sure?") },
        text = { Text(text = "Do you want to delete this file?") },
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "No")
            }
        },
    )
}