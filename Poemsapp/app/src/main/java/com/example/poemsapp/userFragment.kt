package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poemsapp.adapter.UserListAdapter
import com.example.poemsapp.databinding.FragmentUserBinding
import com.example.poemsapp.models.userslist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class userFragment : Fragment() {
    private  lateinit var binding: FragmentUserBinding
    private lateinit var adapter: UserListAdapter
    private var gson: Gson? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         binding = FragmentUserBinding.inflate(layoutInflater, container, false)




        adapter = UserListAdapter(readFromData())
        binding.usertv.adapter = adapter



        return  binding.root
    }

    private fun readFromData(): java.util.ArrayList<userslist> {

        gson = Gson()
        val userData = MySharedPreference.listofUsers
        val type = object: TypeToken<ArrayList<userslist>>(){}.type

        return if(userData != "")
        {
            Gson().fromJson<ArrayList<userslist>>(userData, type)
        } else
        {
            initList()
        }

    }

    private fun initList(): java.util.ArrayList<userslist> {
        var list = ArrayList<userslist>()
        return list
    }
}