package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_item.view.*


class TodoAdapter (val context: Context, val list : ArrayList<Todo>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item,parent, false)
        val count = list.size
        Log.i("size", "count $count")
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {

        val currentItem = list[position]
        holder.setData(currentItem, position)

        holder.itemView.ivEdit.setOnClickListener{

            EditTodoDialog(context,position, currentItem!!.title).show()
            notifyDataSetChanged()

        }
        holder.itemView.ivDelete.setOnClickListener{
                list.remove(currentItem)
                Log.i("removed", "new list $list")
                notifyItemRemoved(position)

        }

    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun setData(currentItem : Todo?, postion : Int) {
            itemView.tvTitle.text = currentItem!!.title

        }



    }


}