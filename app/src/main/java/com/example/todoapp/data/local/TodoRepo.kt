package com.example.todoapp.data.local

import com.example.todoapp.data.Todo

object TodoRepo {
    private val todoList: MutableList<Todo> = mutableListOf()
    fun addNewTodo(item: Todo) {
        todoList.add(item)
    }
    fun getTodoList(): List<Todo> {
        return todoList.toList()
    }
}

