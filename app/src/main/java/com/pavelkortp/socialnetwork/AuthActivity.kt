package com.pavelkortp.socialnetwork

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.util.Log
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

    override fun onStart() {
        super.onStart()
        getLoginDataFromStorage()
    }

    private fun register(): Boolean {
        val email = binding.EmailInput.text.toString()
        val pass = binding.PasswordInput.text.toString()

        if (isInvalidEmail(email) || isInvalidPassword(pass))
            return true

        if(binding.RememberMe.isChecked){
            saveData(email,pass)
        }
        toMainActivity(email, pass)
        return false
    }


    private fun saveData(email: String, pass: String) {
        val sharedPreferences = getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email",email)
        editor.putString("password", pass)
        editor.apply()
    }

    private fun signIn(): Boolean {
        startActivity(
            Intent(this, LoginActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
        return false
    }


    /**
     * Checks if password is invalid
     */
    private fun isInvalidPassword(password: String): Boolean {
        return if (password.isBlank()) {
            binding.PasswordInput.error = "Password is empty"
            true
        } else if (password.length < 8) {
            binding.PasswordInput.error = "Password must be an 8 symbols or more"
            true
        } else
            false
    }

    /**
     * Checks if email is invalid
     */
    private fun isInvalidEmail(email: String): Boolean {
        return if (email.isBlank()) {
            binding.EmailInput.error = "Email is empty"
            true
        }else if (!email.matches(Regex("\\w+[._]\\w+@\\w{5,14}\\.\\w{2,6}"))){
            binding.EmailInput.error = "This is not an email"
            true
        }else
            false
    }

    private fun getLoginDataFromStorage(){
        val sharedPreferences = getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val pass = sharedPreferences.getString("password", "")

        Log.d("DATA", "email $email, pass $pass")

        if (!isInvalidEmail(email.toString()) && !isInvalidPassword(pass.toString())){
            Log.d("DATA", "IN IF")
            toMainActivity(email!!, pass!!)
            finish()
        }
    }

    private fun toMainActivity(email: String, password: String){
        val i = Intent(this, MainActivity::class.java)
        with(i) {
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }
}