package com.pavelkortp.socialnetwork

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityAuthBinding

const val MIN_PASS_LENGTH = 8

class AuthActivity : AppCompatActivity() {

    private val binding: ActivityAuthBinding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        val email = binding.EmailInputLayout.text.toString()
        val pass = binding.PasswordInput.text.toString()

        if (isInvalidEmail(email) || isInvalidPassword(pass))
            return true

        if (binding.RememberMe.isChecked) {
            saveData(email, pass)
        }
        toMainActivity(email, pass)
        return false
    }


    private fun saveData(email: String, pass: String) {
        val sharedPreferences = getSharedPreferences(
            FieldsKeys.PREFERENCES.key,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(FieldsKeys.EMAIL.key, email)
        editor.putString(FieldsKeys.PASSWORD.key, pass)
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
            binding.PasswordInput.error = getString(R.string.password_is_empty)
            true
        } else if (password.length < MIN_PASS_LENGTH) {
            binding.PasswordInput.error = getString(R.string.password_icnorrect)
            true
        } else
            false
    }

    /**
     * Checks if email is invalid
     */
    private fun isInvalidEmail(email: String): Boolean {
        return if (email.isBlank()) {
            binding.EmailInputLayout.error = getString(R.string.email_is_empty)
            true
        } else if (!email.matches(Regex("\\w+[._]\\w+@\\w{5,14}\\.\\w{2,6}"))) {
            binding.EmailInputLayout.error = getString(R.string.email_incorrect)
            true
        } else
            false
    }

    private fun getLoginDataFromStorage() {
        val sharedPreferences = getSharedPreferences(
            FieldsKeys.PREFERENCES.key,
            Context.MODE_PRIVATE
        )
        val email = sharedPreferences.getString(FieldsKeys.EMAIL.key, "")
        val pass = sharedPreferences.getString(FieldsKeys.PASSWORD.key, "")

        if (!isInvalidEmail(email.toString()) && !isInvalidPassword(pass.toString())) {
            toMainActivity(email!!, pass!!)
            finish()
        }
    }

    private fun toMainActivity(email: String, password: String) {
        with(Intent(this, MainActivity::class.java)) {
            putExtra(FieldsKeys.EMAIL.key, email)
            putExtra(FieldsKeys.PASSWORD.key, password)
            startActivity(this)
        }
    }
}