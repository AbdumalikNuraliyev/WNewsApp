package com.example.poemsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poemsapp.databinding.UserItemsBinding
import com.example.poemsapp.models.userslist

class UserListAdapter(var list: ArrayList<userslist>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: UserItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(user: userslist) {
            binding.username.text = user.username
            binding.emailitem.text = user.email

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}



