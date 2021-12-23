package com.example.poemsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poemsapp.databinding.PoemlistBinding
import com.example.poemsapp.models.poemlist

class PoemListAdapter(var list : ArrayList<poemlist>): RecyclerView.Adapter<PoemListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: PoemlistBinding): RecyclerView.ViewHolder(binding.root)
    {

        fun onBind(poem:poemlist)
        {
            binding.poemname.text = poem.poemname
            binding.author.text = poem.author
            binding.authorpoem.text = poem.poem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PoemlistBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int  = list.size
}