package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.databinding.FragmentAddPoemBinding
import com.example.poemsapp.models.poemlist
import com.example.poemsapp.models.userslist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AddPoemFragment : Fragment() {
  private  lateinit var binding: FragmentAddPoemBinding
    var gson: Gson? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAddPoemBinding.inflate(layoutInflater, container, false)

        MySharedPreference.init(requireContext())
        val list: ArrayList<poemlist> = readFromData()


binding.addpoem.setOnClickListener {

    var poem = binding.Poems.text.toString()
    var poemname = binding.poemname.text.toString()
    var author = binding.author.text.toString()


    if(poem != "" && poemname != ""&& author != "")
    {
        list.add(poemlist(poemname,author,poem))
        val toJson = gson?.toJson(list)
        MySharedPreference.listOfPoem = toJson
        findNavController().navigate(R.id.poemFragment)
        Toast.makeText(requireContext(), "Added user", Toast.LENGTH_SHORT).show()

    }
    else{
        Toast.makeText(requireContext(), "Maydonlarni to'ldiring", Toast.LENGTH_SHORT)
            .show()
    }




}






     return binding.root
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