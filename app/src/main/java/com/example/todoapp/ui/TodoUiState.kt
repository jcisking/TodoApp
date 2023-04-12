package com.example.todoapp.ui

import com.example.todoapp.data.Todo

data class TodoUiState(
    val listOfTodos: List<Todo>,
    val todoInputValue: String,
    val isCompletedSelected: Boolean,
    val isActiveSelected: Boolean
)
