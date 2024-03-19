package com.pavelkortp.socialnetwork

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginBTN.setOnClickListener {
            login()
        }

        binding.SignUpText.setOnClickListener {
            signUp()
        }

        window.enterTransition = Slide()
        window.exitTransition = Slide()
    }

    private fun login(): Boolean {
        val email = binding.EmailInput.text.toString()
        val pass = binding.PasswordInput.text.toString()

        if (email.isBlank()) {
            binding.EmailInput.error = "Email is empty"
            return true
        } else if(pass.isBlank()) {
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

    private fun signUp(): Boolean {
        startActivity(
            Intent(this, AuthActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
        return false
    }
}