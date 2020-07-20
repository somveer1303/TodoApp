package com.example.todoapp

import android.text.Editable

data class Todo(var title: String)

    var list = arrayListOf<Todo>(
        Todo("Buy Apple"),
        Todo("Complete App")

    )
