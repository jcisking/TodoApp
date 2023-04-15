package com.example.todoapp.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
//import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.data.Todo

@Composable
fun TodoApp() {
//    val viewModel: TodoViewModel = viewModel()
//    val todoUiState = viewModel.uiState.collectAsState().value
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

//            TodoInput(
//                value = todoUiState.todoInputValue,
//                onValueChange = {viewModel.updateTodoInputValue(it)}
//            )

//            LazyColumn() {
//                items(todoUiState.listOfTodos) { todo ->
//                    TodoListItem(
//                        isCompleted = todo.isCompleted ,
//                        todo = todo
//                    )
//                }
//            }
        }
    }
}

@Composable
fun TodoInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange
    )
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
    todo: Todo,
    modifier: Modifier = Modifier,
    isCompleted: Boolean
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {

        Icon(
            painter = painterResource(id = R.drawable.unfilled_radio_button),
            contentDescription = null
        )

        Text(text = todo.todoText)

        Icon(
            painter = painterResource(id = R.drawable.icon_cross),
            contentDescription = null
        )

        
    }

}
