package com.example.todoapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun TodoApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.bg_mobile_dark),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 40.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoTopBar()
            TodoListItem(modifier = Modifier.padding(top = 30.dp))


        }
    }
}

@Composable
fun TodoTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.top_bar_text),
            style = MaterialTheme.typography.h1
        )
        Icon(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = null
        )
    }
}

@Composable
fun TodoListItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier) {
            Icon(painter = painterResource(id = R.drawable.icon_cross), contentDescription = null)
            Icon(
                modifier = Modifier.background(Color.Blue),
                painter = painterResource(id = R.drawable.radio_button_unchecked_fill0_wght400_grad0_opsz48),
                tint = Color.Green,
                contentDescription = null
            )
        }
        Text(text = "adklsdf")

        Icon(
            painter = painterResource(id = R.drawable.icon_cross),
            contentDescription = null
        )

        
    }

}