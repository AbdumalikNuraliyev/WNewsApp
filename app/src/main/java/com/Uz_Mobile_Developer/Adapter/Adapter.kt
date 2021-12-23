package com.Uz_Mobile_Developer.Adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Uz_Mobile_Developer.Adapter.Adapter.*
import com.Uz_Mobile_Developer.EditFragment
import com.Uz_Mobile_Developer.Model.Task
import com.Uz_Mobile_Developer.databinding.ViewBinding

class Adapter(var list: List<Task>, val onClick: (task: Task, position: Int) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        var layout = binding.mylayout
        var layouts = binding.mylayoutled
        fun onBind(task: Task, position: Int) {
            binding.title.text = task.note.toString()
           // binding.priority.text = task.priority.toString()
            binding.time.text = task.time.toString()
            binding.desc.text = task.decs.toString()
            itemView.setOnClickListener {
                onClick(task, position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (list[position].priority?.toLowerCase()) {

            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#D50000"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#FFAB00"))
            "low" -> holder.layout.setBackgroundColor(Color.parseColor("#76FF03"))

        }
        when (list[position].priority?.toLowerCase()) {
            "high" -> holder.layouts.setBackgroundColor(Color.parseColor("#D50000"))

            "medium" -> holder.layouts.setBackgroundColor(Color.parseColor("#FFAB00"))

            "low" -> holder.layouts.setBackgroundColor(Color.parseColor("#76FF03"))


        }
//            holder.itemView.setOnClickListener {
//                val intent =  Intent(holder.itemView.context,EditFragment::class.java)
//                intent.putExtra("id",position)
//                holder.itemView.context.startActivity(intent)
//            }


        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}