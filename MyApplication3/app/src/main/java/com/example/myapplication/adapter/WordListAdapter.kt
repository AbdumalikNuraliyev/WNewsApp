package com.example.myapplication.adapter

import Word
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.WordItemBinding
import com.example.myapplication.ui.home.HomeFragment

class WordListAdapter(val listener: HomeFragment):RecyclerView.Adapter<WordListAdapter.ViewHolder>(){


    var list :List<Word> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    set(value){
field = value
notifyDataSetChanged()
    }


  inner  class ViewHolder(private  val binding: WordItemBinding):RecyclerView.ViewHolder(binding.root) {
      @SuppressLint("ClickableViewAccessibility")
      fun onBind(word: Word) {
          binding.word.text = word.word
          binding.wordtranslate.text = word.translate

          itemView.setOnClickListener {
              listener.onItemViewClick(word)

          }
      }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(WordItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    @SuppressLint("ClickableViewAccessibility", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int = list.size

}
interface OnClick{
    fun  onItemViewClick(word: Word)
}