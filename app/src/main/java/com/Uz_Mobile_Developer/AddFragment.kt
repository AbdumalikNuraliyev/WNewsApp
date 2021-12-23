package com.Uz_Mobile_Developer

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.Uz_Mobile_Developer.Adapter.Adapter
import com.Uz_Mobile_Developer.Model.Task
import com.Uz_Mobile_Developer.RoomDbHelper.RoomDbHelper
import com.Uz_Mobile_Developer.databinding.FragmentAddBinding
import java.util.*

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var adapter: Adapter
    private lateinit var roomDbHelper: RoomDbHelper
    private lateinit var Task: Task
    var priority = ""

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        roomDbHelper = RoomDbHelper.DatabaseBuilder.getInstance(requireContext())

        binding.time.setOnClickListener {

            val c = Calendar.getInstance()
            val myear = c.get(Calendar.YEAR)
            val mmonth = c.get(Calendar.MONTH)
            val mday = c.get(Calendar.DAY_OF_MONTH)

            val picker = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->

                    binding.time.setText("$dayofmonth/$month/$year")
                    binding.time.setTextColor(Color.parseColor("#F44336"))
                },
                myear,
                mmonth,
                mday
            )

            picker.show()


        }

        binding.savebtn.setOnClickListener {

            if (binding.radiogroup.checkedRadioButtonId == -1) {
                Toast.makeText(requireContext(), "Iltimos radio button tanlang", Toast.LENGTH_SHORT)
                    .show()
            } else {

                val task = binding.task.text.toString()
                val time = binding.time.text.toString()
                val desc = binding.description.text.toString()
                val deadline = binding.deadline.text.toString()
                val id: Int = binding.radiogroup.checkedRadioButtonId
                when (id) {
                    R.id.low -> {
                        priority = "Low"
                    }
                    R.id.medium -> {
                        priority = "Medium"
                    }
                    R.id.high -> {
                        priority = "High"
                    }

                }
                if (task.toString().isEmpty()) {
                    Toast.makeText(requireContext(), "Iltimos Vazifa qo`shing", Toast.LENGTH_SHORT)
                        .show()
                }

                if (time.isEmpty()) {
                    Toast.makeText(requireContext(), "Iltimos Vaqtni qo`shing ", Toast.LENGTH_SHORT)
                        .show()
                }

                if (task.isNotEmpty() && time.isNotEmpty() && priority.isNotEmpty() && deadline.isNotEmpty() && desc.isNotEmpty()) {

                    val taskobj = Task(note = task, time = time, priority = priority, decs = desc)
                    roomDbHelper.roomDao().insert(taskobj)
                    Toast.makeText(requireContext(), "Successful Added", Toast.LENGTH_SHORT).show()
                    binding.task.text = null
                    binding.time.text = null
                    binding.deadline.text = null
                    binding.description.text = null
                    binding.radiogroup.clearCheck()

                    findNavController().navigate(
                        R
                            .id.listFragment
                    )
                }


            }
        }


        return binding.root
    }


}