package com.example.todoapp.ui

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Todo
import com.example.todoapp.data.local.TodoRepo
import kotlinx.coroutines.flow.MutableStateFlow

class TodoViewModel: ViewModel() {
    private val uiState_ = MutableStateFlow(TodoUiState(listOfTodos = TodoRepo.todoList))




    fun addNewTodo(newTodoItem: Todo) {
        TodoRepo.todoList.add(newTodoItem)
    }
}