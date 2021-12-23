package com.example.myapplication.ui.gallery

import Word
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.database.DbHelper
import com.example.myapplication.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentGalleryBinding.inflate(inflater, container, false)




    var dbHelper = DbHelper(requireContext())


        var list = dbHelper.listOfWords()

        binding.savebtn.setOnClickListener {
            val word = binding.wordln.text.toString()
            val translate = binding.translateln.text.toString()
            // val other = binding.russian.text.toString()
            var index = -1
            if (word.trim().isNotEmpty() && translate.trim().isNotEmpty()) {

                for (i in 0 until list.size)
                {
                    if(word.equals(list[i].word, true))
                    {
                        index = i
                    }
                }
                if(index > -1)
                {
                    Toast.makeText(requireContext(), "Exist word", Toast.LENGTH_SHORT).show()
                }
                else {
                    val wordObj = Word(word, translate)
                    dbHelper.AddWord(wordObj)
                    binding.wordln.text.clear()
                    binding.translateln.text.clear()
                    //  binding.russian.text.clear()

                    Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Word or Translate not added !!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return  binding.root
    }


}