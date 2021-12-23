package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.adapter.PoemListAdapter
import com.example.poemsapp.adapter.UserListAdapter
import com.example.poemsapp.databinding.FragmentPoemBinding
import com.example.poemsapp.models.poemlist
import com.example.poemsapp.models.userslist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class poemFragment : Fragment() {

    private  lateinit var binding: FragmentPoemBinding
    private lateinit var adapter: PoemListAdapter
    private var gson: Gson? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPoemBinding.inflate(layoutInflater, container, false)




        adapter = PoemListAdapter(readFromData())
        binding.poemtv.adapter = adapter


        binding.fab.setOnClickListener {

            findNavController().navigate(R.id.addPoemFragment)
        }



      return  binding.root
    }


    private fun readFromData(): java.util.ArrayList<poemlist> {

        gson = Gson()
        val userData = MySharedPreference.listOfPoem
        val type = object: TypeToken<ArrayList<poemlist>>(){}.type

        return if(userData != "")
        {
            Gson().fromJson<ArrayList<poemlist>>(userData, type)
        } else
        {
            initList()
        }

    }

    private fun initList(): java.util.ArrayList<poemlist> {
        var list = ArrayList<poemlist>()
        return list
    }

}