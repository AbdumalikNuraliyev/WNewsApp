package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.adapter.UserListAdapter
import com.example.poemsapp.databinding.FragmentLogBinding
import com.example.poemsapp.models.userslist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class logFragment : Fragment() {

    private lateinit var binding: FragmentLogBinding

    var gson: Gson? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLogBinding.inflate(layoutInflater, container, false)

        MySharedPreference.init(requireContext())
        val list: ArrayList<userslist> = readFromData()
        binding.yashirinreg.visibility = View.GONE


        binding.yashirinreg.setOnClickListener {
            findNavController().navigate(R.id.regFragment)
        }


        binding.signins.setOnClickListener {
            val login = binding.namesign.text.toString()
            val pasword = binding.passsign.text.toString()





            if (login != "" && pasword != "") {
                for (i in 0 until list.size) {
                    if (login == list[i].username && pasword == list[i].password) {
                        findNavController().navigate(R.id.yunalishFragment)
                       // findNavController().popBackStack(R.id.yunalishFragment, false)
                       // findNavController().popBackStack()
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    }
                }
            } else{
                Toast.makeText(requireContext(), "Siz hali Registratsiyadan o`tmaganga o`xshaysiz \n Iltimos registratsiyadan O`ting", Toast.LENGTH_SHORT).show()
                binding.yashirinreg.visibility = View.VISIBLE
            }

           if (login == "" || pasword ==""){
               Toast.makeText(requireContext(), "Iltimos To`liq yozing", Toast.LENGTH_SHORT).show()
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