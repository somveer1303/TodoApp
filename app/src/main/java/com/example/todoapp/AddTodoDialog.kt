package com.example.todoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import kotlinx.android.synthetic.main.floating_add_todo.*


class AddTotoDialog(context: Context?) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.floating_add_todo)

        btnAdd.setOnClickListener{
            val title = etTitle.text
            val data  = Todo(title.toString())
            list.add(data)
            Log.i("etext", "text is $list")
            val adapter = TodoAdapter(context, list)
            adapter.notifyDataSetChanged()
            dismiss()

        }

    }
}