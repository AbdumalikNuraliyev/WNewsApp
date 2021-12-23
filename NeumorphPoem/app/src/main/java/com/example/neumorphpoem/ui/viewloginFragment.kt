package com.example.neumorphpoem.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neumorphpoem.R
import com.example.neumorphpoem.databinding.FragmentViewloginBinding


class viewloginFragment : Fragment() {
  private  lateinit var  binding: FragmentViewloginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewloginBinding.inflate(layoutInflater, container, false)














        return binding.root
    }


}