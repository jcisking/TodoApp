package com.example.todoapp.data.local

import com.example.todoapp.data.Todo

object TodoRepo {
    private val todoList: MutableList<Todo> = mutableListOf()
    fun addNewTodo(item: Todo) {
        todoList.add(index = 0, element = item)
    }
    fun getTodoList(): List<Todo> {
        return todoList.toList()
    }
    fun toggleIsCompleted(index: Int) {
        todoList[index].isCompleted = !todoList[index].isCompleted
    }
}

