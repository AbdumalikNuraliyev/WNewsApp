package com.example.instagram.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram.AccActivity2
import com.example.instagram.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentProfileBinding.inflate(layoutInflater, container, false)




binding.edit.setOnClickListener {
//    val intent = Intent(activity,AccountSettingsActivity::class.java)
//   activity?.startActivity(intent)
requireActivity().run {
    startActivity(Intent(this,AccActivity2::class.java))
    finish()
}



}



return binding.root
    }

}