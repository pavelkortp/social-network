package com.pavelkortp.socialnetwork

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val email = intent.getStringExtra(FieldsKeys.EMAIL.key)
        setNameFromEmail(email!!)

        binding.LogOut.setOnClickListener {
            logout()
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
        window.enterTransition = Slide()
        window.exitTransition = Slide()

    }

    private fun setNameFromEmail(email: String): Unit {
        binding.Name.text = email
            .substring(0, email.indexOf('@'))
            .split(Regex("[._]"))
            .joinToString(" ") { e -> e.replaceFirstChar { it.uppercase() } }
    }

    private fun logout() {
        getSharedPreferences(
            FieldsKeys.PREFERENCES.key,
            Context.MODE_PRIVATE
        )
            .edit()
            .clear()
            .apply()
    }
}