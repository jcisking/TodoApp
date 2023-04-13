package com.example.todoapp.ui

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Todo
import com.example.todoapp.data.local.TodoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TodoUiState(listOfTodos = TodoRepo.todoList))
    val uiState = _uiState.asStateFlow()




    fun addNewTodo(newTodoItem: Todo) {
        TodoRepo.todoList.add(newTodoItem)
    }
}