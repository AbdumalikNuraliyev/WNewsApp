package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import com.example.myapplication.databinding.ActivitySplash2Binding
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Wave

class SplashActivity : AppCompatActivity() {
    private  lateinit var binding: ActivitySplash2Binding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
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