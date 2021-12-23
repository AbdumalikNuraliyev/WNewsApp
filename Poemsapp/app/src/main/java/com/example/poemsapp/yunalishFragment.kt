package com.example.poemsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.databinding.FragmentYunalishBinding

class yunalishFragment : Fragment() {

    private  lateinit var  binding: FragmentYunalishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentYunalishBinding.inflate(layoutInflater, container, false)


binding.users.setOnClickListener {
    findNavController().navigate(R.id.userFragment)
}
binding.poems.setOnClickListener {
    findNavController().navigate(R.id.poemFragment)
}








        return  binding.root
    }


}