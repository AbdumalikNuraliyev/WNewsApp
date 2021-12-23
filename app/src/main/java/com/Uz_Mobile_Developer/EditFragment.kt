package com.Uz_Mobile_Developer

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.Uz_Mobile_Developer.Adapter.Adapter
import com.Uz_Mobile_Developer.Model.Task
import com.Uz_Mobile_Developer.RoomDbHelper.RoomDbHelper
import com.Uz_Mobile_Developer.databinding.FragmentEditBinding
import java.util.*


class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private lateinit var adapter: Adapter
    private lateinit var roomDbHelper: RoomDbHelper
    private lateinit var Task: Task
    var priority = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditBinding.inflate(layoutInflater, container, false)

        roomDbHelper = RoomDbHelper.getInstance(requireContext())
        binding.time.setOnClickListener {

            var c = Calendar.getInstance()
            var myear = c.get(Calendar.YEAR)
            var mmonth = c.get(Calendar.MONTH)
            var mday = c.get(Calendar.DAY_OF_MONTH)

            var picker = DatePickerDialog(
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
        var bundle = arguments
        var tasks = bundle?.getSerializable("key") as Task
        binding.createTitle.setText(tasks.note)
        binding.deadline.setText(tasks.deadline)
        binding.description.setText(tasks.decs)
        binding.time.setText(tasks.time)
        var ids = tasks.id

        binding.updatebtn.setOnClickListener {




            if (binding.createTitle.text.toString().isNotEmpty() && binding.deadline.text
                    .toString().isNotEmpty() && binding.description.text.toString()
                    .isNotEmpty() && binding.time.text.toString().isNotEmpty()
                && binding.radiogroup.checkedRadioButtonId != -1
            ) {


                var task = binding.createTitle.text.toString()
                var time = binding.time.text.toString()
                var desc = binding.description.text.toString()
                var deadline = binding.deadline.text.toString()
                var id: Int = binding.radiogroup.checkedRadioButtonId
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

                var taskobj = Task(id = ids,note = task,decs = desc,deadline = deadline,time = time,priority = priority)
                roomDbHelper.roomDao().edit(taskobj)
                Toast.makeText(requireContext(), "Successful Changed", Toast.LENGTH_SHORT).show()
                binding.createTitle.text = null
                binding.time.text = null
                binding.deadline.text = null
                binding.description.text = null
                binding.radiogroup.clearCheck()

                findNavController().navigate(R.id.listFragment)

            } else {

                Toast.makeText(
                    requireContext(),
                    "Iltimos yaxshilab qarang xatolik bor !!",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

        return binding.root
    }


}