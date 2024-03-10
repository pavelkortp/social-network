package com.pavelkortp.socialnetwork

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LogOut.setOnClickListener {
            closeApp()
        }
    }

    private fun closeApp(){
        binding.Name.setTextColor(Random.nextInt())
    }
}