package com.pavelkortp.socialnetwork

import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Hekkof")

        binding.Name.text = intent.getStringExtra("email")

        binding.LogOut.setOnClickListener{
            startActivity(Intent(this, AuthActivity::class.java))
        }
        window.enterTransition = Slide()
        window.exitTransition = Slide()

    }

    companion object{
        @JvmStatic val TAG = MainActivity::class.simpleName
    }

}