package com.example.myapplication.ui.home

import Word
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapter.OnClick
import com.example.myapplication.adapter.WordListAdapter
import com.example.myapplication.database.DbHelper
import com.example.myapplication.databinding.FragmentHomeBinding
class HomeFragment : Fragment(),OnClick {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: WordListAdapter
    private lateinit var dbHelper: DbHelper


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        dbHelper = DbHelper(requireContext())


        setData(dbHelper.listOfWords())

        return binding.root
    }
    private fun setData(list: List<Word>){
        adapter = WordListAdapter(this)
        adapter.list = list
        binding.rv.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    override fun onItemViewClick(wordd: Word) {

        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val dialogView = layoutInflater.inflate(R.layout.menu_dialog, null, false)


        val words = dialogView.findViewById<TextView>(R.id.wordsss)
        val translates = dialogView.findViewById<TextView>(R.id.translatesss)
        val delete = dialogView.findViewById<LinearLayout>(R.id.delete)
        val edit = dialogView.findViewById<LinearLayout>(R.id.edit)
        val share = dialogView.findViewById<LinearLayout>(R.id.share)
        val love = dialogView.findViewById<LinearLayout>(R.id.love)

        words.text = wordd.word
        translates.text = wordd.translate
        delete.setOnClickListener {
            dbHelper.deleteWord(wordd)
            dialog.dismiss()
            setData(dbHelper.listOfWords())
        }
        edit.setOnClickListener {
            editDilaog(wordd)
            dialog.cancel()
        }

        share.setOnClickListener {
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, wordd.word + "\n" + wordd.translate)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
            dialog.cancel()
        }

        love.setOnClickListener {

        }

        dialog.setView(dialogView)
        dialog.show()
    }

    fun editDilaog(soz: Word)
    {
        val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext()).create()
        val dialogView = layoutInflater.inflate(R.layout.edit_dialog, null, false)
        //dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        val word = dialogView.findViewById<TextView>(R.id.worded)
        val translate = dialogView.findViewById<TextView>(R.id.translateed)
        val save = dialogView.findViewById<Button>(R.id.saveed)

        word.text = soz.word
        translate.text = soz.translate


        save.setOnClickListener {

            var list = dbHelper.listOfWords()
            val word = dialogView.findViewById<TextView>(R.id.worded).text.toString()
            val translate = dialogView.findViewById<TextView>(R.id.translateed).text.toString()

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
                    dbHelper.edit(wordObj, soz.id)
                    dialog.cancel()

                    Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Word or Translate not added !!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            dialog.dismiss()
            setData(dbHelper.listOfWords())
        }

        dialog.setView(dialogView)
        dialog.show()
    }
}