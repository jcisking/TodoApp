package com.example.todoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import com.example.todoapp.R

@Composable
fun TodoApp() {
    Column() {
        Image(painterResource(id = R.drawable.bg_desktop_dark), contentDescription = null)
        Text(text = "dsfasfdk")
    }
    

}