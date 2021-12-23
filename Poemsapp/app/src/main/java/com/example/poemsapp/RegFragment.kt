package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.databinding.FragmentRegBinding
import com.example.poemsapp.models.userslist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class RegFragment : Fragment() {

    private  lateinit var  binding: FragmentRegBinding
    var gson: Gson? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(layoutInflater, container, false)

        MySharedPreference.init(requireContext())
        val list: ArrayList<userslist> = readFromData()


        binding.sigupreg.setOnClickListener {

            val username = binding.namereg.text.toString()
            val email = binding.emailreg.text.toString()
            val password = binding.passreg.text.toString()

            if(username != "" && email != ""&& password != "")
            {
                list.add(userslist(username, email, password))
                val toJson = gson?.toJson(list)
                MySharedPreference.listofUsers = toJson
                findNavController().navigate(R.id.yunalishFragment)
                Toast.makeText(requireContext(), "Added user", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(requireContext(), "Maydonlarni to'ldiring", Toast.LENGTH_SHORT)
                    .show()
            }
        }



            return binding.root

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