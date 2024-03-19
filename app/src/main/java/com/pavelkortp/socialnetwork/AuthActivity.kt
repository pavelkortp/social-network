package com.pavelkortp.socialnetwork

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RegisterBTN.setOnClickListener {
            register()
        }

        binding.SignInText.setOnClickListener {
            signIn()
        }



        window.enterTransition = Slide()
    }

    private fun register(): Boolean {
        val email = binding.EmailInput.text.toString()
        val pass = binding.PasswordInput.text.toString()

        if (email.isBlank()) {
            binding.EmailInput.error = "Email is empty"
            return true
        }
        if (pass.isBlank()) {
            binding.PasswordInput.error = "Password is empty"
            return true
        }
        val i = Intent(this, MainActivity::class.java)

        with(i) {
            putExtra("email", email)
            putExtra("password", pass)
        }
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        return false
    }

    private fun signIn():Boolean{
        startActivity(
            Intent(this, LoginActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
        return false
    }
}