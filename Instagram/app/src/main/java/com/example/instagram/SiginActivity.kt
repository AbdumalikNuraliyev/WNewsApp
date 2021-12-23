package com.example.instagram

import android.R
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.databinding.ActivitySiginBinding
import android.content.DialogInterface




class SiginActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySiginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySiginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signUpLinkBtn.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
            finish()
        }


    }


    override fun onBackPressed() {

        AlertDialog.Builder(this)
            .setTitle("Really Exit?")
            .setMessage("Are you sure you want to exit?")
            .setNegativeButton(R.string.no, null)
            .setPositiveButton(R.string.yes, object : DialogInterface.OnClickListener {
                override fun onClick(arg0: DialogInterface?, arg1: Int) {
                    super@SiginActivity.onBackPressed()
                }
            }).create().show()
    }
}