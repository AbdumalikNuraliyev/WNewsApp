package com.Uz_Mobile_Developer

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.room.Database
import com.Uz_Mobile_Developer.Adapter.Adapter
import com.Uz_Mobile_Developer.Model.Task
import com.Uz_Mobile_Developer.RoomDbHelper.RoomDbHelper
import com.Uz_Mobile_Developer.databinding.BottomSheetDialogBinding
import com.Uz_Mobile_Developer.databinding.FragmentListBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: Adapter
    private lateinit var task: Task
    private lateinit var roomDbHelper: RoomDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val helper = RoomDbHelper.DatabaseBuilder
        roomDbHelper = helper.getInstance(requireContext())


        setAdapter(roomDbHelper.roomDao().allTask())
        binding.add.setOnClickListener {

            findNavController().navigate(R.id.addFragment)

        }
        return binding.root

    }

    private fun setAdapter(list: List<Task>) {
        adapter = Adapter(list) { it, position ->
            showBottomSheetDialog(it)
        }
        binding.recyclerView.adapter = adapter


    }





    private fun showBottomSheetDialog(task: Task) {

        val roomDbHelper: RoomDbHelper = RoomDbHelper.DatabaseBuilder.getInstance(requireContext())
        val dialog = BottomSheetDialog(requireContext())
        val dialogView =BottomSheetDialogBinding.inflate(layoutInflater, null, false)

        dialogView.titlesheet.text = task.note.toString()
        dialogView.datatimesheet.text = task.time.toString()
        dialogView.descriptionsheet.text = task.decs.toString()
        dialogView.prioritysheet.text = task.priority.toString()

        val edit = dialogView.edit
        val delete = dialogView.delete
        val share = dialogView.share

        when(dialogView.prioritysheet.text.toString().toLowerCase()){

            "high" -> dialogView.mylayoutled.setBackgroundColor(Color.parseColor("#D50000"))
            "medium" ->dialogView.mylayoutled.setBackgroundColor(Color.parseColor("#FFAB00"))
            "low" -> dialogView.mylayoutled.setBackgroundColor(Color.parseColor("#76FF03"))
        }
        when(dialogView.prioritysheet.text.toString().toLowerCase()){

            "high" -> dialogView.mylayout.setBackgroundColor(Color.parseColor("#D50000"))
            "medium" ->dialogView.mylayout.setBackgroundColor(Color.parseColor("#FFAB00"))
            "low" -> dialogView.mylayout.setBackgroundColor(Color.parseColor("#76FF03"))

        }

        delete.setOnClickListener {

            roomDbHelper.roomDao().delete(task)
            setAdapter(roomDbHelper.roomDao().allTask())
            Toast.makeText(requireContext(), "Task deleted", Toast.LENGTH_SHORT).show()
            dialog.cancel()

        }


        edit.setOnClickListener {
            val viewFragment = EditFragment()
            val bundle = Bundle()
            bundle.putSerializable("key", task)
            viewFragment.setArguments(bundle)

            dialog.cancel()
            findNavController().navigate(R.id.editFragment,bundle)
        }


        share.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, task.note)

            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
        dialog.setContentView(dialogView.root)
        dialog.show()


    }

}

