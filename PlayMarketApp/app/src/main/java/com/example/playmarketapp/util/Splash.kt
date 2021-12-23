package com.example.playmarketapp.util

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.github.ybq.android.spinkit.sprite.Sprite
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import com.example.playmarketapp.R
import com.example.playmarketapp.databinding.ActivitySplashBinding
import com.github.ybq.android.spinkit.style.Wave


class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val progressBar = findViewById<View>(com.example.playmarketapp.R.id.spin_kit) as ProgressBar
        val doubleBounce: Sprite = Wave()
        progressBar.indeterminateDrawable = doubleBounce


        val img = binding.aylana
        val anim = AnimationUtils.loadAnimation(this, R.animator.jj)
        img.startAnimation(anim)
        Handler(Looper.getMainLooper()).postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)


    }
}