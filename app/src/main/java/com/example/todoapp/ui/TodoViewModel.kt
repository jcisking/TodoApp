package com.example.todoapp.ui

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Todo
import com.example.todoapp.data.local.TodoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TodoUiState(listOfTodos = TodoRepo.getTodoList()))
    val uiState = _uiState.asStateFlow()




    fun addNewTodo(newTodoItem: Todo) {
        TodoRepo.addNewTodo(newTodoItem)
        val updatedTodoList = TodoRepo.getTodoList()
        _uiState.update {
            it.copy(
                listOfTodos = updatedTodoList
            )
        }
    }

    fun toggleIsCompleted(index: Int) {
        TodoRepo.toggleIsCompleted(index)
        val updatedTodoList = TodoRepo.getTodoList()
        _uiState.update {
            it.copy(
                listOfTodos = updatedTodoList
            )
        }
    }
}