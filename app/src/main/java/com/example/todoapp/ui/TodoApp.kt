package com.example.todoapp.ui

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.data.Todo
import com.example.todoapp.ui.theme.DarkGrayishBlue
import com.example.todoapp.ui.theme.VeryDarkBlue
import com.example.todoapp.ui.theme.VeryDarkDesaturatedBlue
import com.example.todoapp.ui.theme.VeryDarkGrayishBlueDark1

@Composable
fun TodoApp() {
    val viewModel: TodoViewModel = viewModel()
    val todoUiState = viewModel.uiState.collectAsState().value
    val focusManager = LocalFocusManager.current

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

            TodoInput(
                value = todoUiState.todoInputValue,
                label = R.string.enter_new_todo,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (todoUiState.todoInputValue == "" ) {
                            focusManager.clearFocus()
                        }
                        else {
                            viewModel.addNewTodo(Todo(todoText = todoUiState.todoInputValue))
                            viewModel.updateTodoInputValue("")
                        }
                    }

                ),
                onValueChange = {viewModel.updateTodoInputValue(it)}
            )

            TodoLazyList(
                todoUiState = todoUiState,
                onTodoClicked = {viewModel.toggleIsCompleted(index = it)}
            )
            RemainingTodosAndClearButtonRow(uiState = todoUiState)
            TodoBottomAppBar()


        }
    }
}

@Composable
private fun TodoLazyList(
    todoUiState: TodoUiState,
    onTodoClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .height(300.dp)
    ) {
        itemsIndexed(todoUiState.listOfTodos) { index, todo ->
            TodoListItem(
                todo = todo,
                onTodoClicked = {onTodoClicked(index)},
            )
        }
    }
}

@Composable
fun TodoInput(
    value: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    @StringRes label: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = VeryDarkDesaturatedBlue
        ),
        label = {Text(stringResource(id = label))},
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun TodoTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
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
    onTodoClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable  {onTodoClicked} ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            modifier = Modifier.size(25.dp),
            painter =
            if (todo.isCompleted) {
                painterResource(id = R.drawable.filled_radio_button)
            }
            else {
                painterResource(id = R.drawable.unfilled_radio_button)
                 },
            contentDescription = null
        )

        Text(
            modifier = modifier.weight(1f),
            text = todo.todoText
        )

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.icon_cross),
                contentDescription = null
            )
        }



        
    }

}


@Composable
fun RemainingTodosAndClearButtonRow(
    uiState: TodoUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val sizeOfTodoList = uiState.listOfTodos.size.toString()
        Text(text = stringResource(
            id = R.string.todos_remaining,
            formatArgs = arrayOf(sizeOfTodoList)
            )
        )
        Text(text = stringResource(id = R.string.clear_completed))
        
    }

}

@Composable
fun TodoBottomAppBar(
    modifier: Modifier = Modifier 
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(text = stringResource(id = R.string.bottom_app_bar_all))
        
        Text(text = stringResource(id = R.string.bottom_app_bar_active) )
        
        Text(text = stringResource(id = R.string.bottom_app_bar_completed))
        
    }
}
