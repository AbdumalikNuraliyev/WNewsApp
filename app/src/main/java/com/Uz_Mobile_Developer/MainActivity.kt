package com.Uz_Mobile_Developer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Uz_Mobile_Developer.Adapter.Adapter
import com.Uz_Mobile_Developer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}