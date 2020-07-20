package com.example.todoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import kotlinx.android.synthetic.main.floating_add_todo.*
import kotlinx.android.synthetic.main.floating_edit_todo.*

class EditTodoDialog(context: Context,val index : Int, val dataa : String) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("test","running till now")

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.floating_edit_todo)
        etTitleEdit.setText(dataa)

        btnEdit.setOnClickListener{

            val title = etTitleEdit.text
            val data  = Todo(title.toString())
            list.set(index, data)
            Log.i("edit_text", "text is $list")
            val adapter = TodoAdapter(context, list)
//            adapter.notifyItemRemoved(index)
////            adapter.notifyItemInserted(index)
//            adapter.notifyDataSetChanged()
            adapter.notifyDataSetChanged()
            dismiss()
        }

    }
}