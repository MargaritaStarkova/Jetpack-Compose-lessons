package com.example.material_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is scaffold content"
        )
    }
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