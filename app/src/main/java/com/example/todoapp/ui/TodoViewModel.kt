package com.example.todoapp.ui

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Todo
import com.example.todoapp.data.local.TodoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.isActive
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

    fun updateTodoInputValue(todoInput: String) {
        _uiState.update {
            it.copy(
                todoInputValue = todoInput
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

    fun onActiveClicked() {
        val isActiveSelected = _uiState.value.isActiveSelected
        _uiState.update {
            it.copy(
                isActiveSelected = !isActiveSelected
            )
        }
    }

    fun onCompletedClicked() {
        val isCompletedSelected = _uiState.value.isCompletedSelected
        _uiState.update {
            it.copy(
                isCompletedSelected = isCompletedSelected
            )
        }
    }

    fun onAllSelected() {
        _uiState.update {
            it.copy(
                isCompletedSelected = false,
                isActiveSelected = false
            )
        }
    }
}