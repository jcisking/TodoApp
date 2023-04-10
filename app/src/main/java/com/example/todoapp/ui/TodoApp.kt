package com.example.todoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun TodoApp() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(

            painter = painterResource(id = R.drawable.bg_mobile_dark),
            contentDescription = null
        )
        Column {
           TodoTopBar()

        }

    }
}

@Composable
fun TodoTopBar() {
    Row() {
        Text(text = stringResource(id = R.string.top_bar_text) )
        Image(painter = painterResource(id = R.drawable.icon) , contentDescription = null)
    }
}