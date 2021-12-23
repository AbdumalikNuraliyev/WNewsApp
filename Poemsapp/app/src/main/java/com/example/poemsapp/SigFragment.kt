package com.example.poemsapp
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.poemsapp.databinding.FragmentSigBinding


class SigFragment : Fragment() {
    private lateinit var binding: FragmentSigBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSigBinding.inflate(layoutInflater, container, false)


        binding.signup.setOnClickListener {

            findNavController().navigate(R.id.logFragment)

        }
        binding.signin.setOnClickListener {

            findNavController().navigate(R.id.regFragment)

        }

        return binding.root

    }

//    fun fillList(){
//        list.add(userslist("ugwuyis","wyguigdiasg"))
//    }

}

