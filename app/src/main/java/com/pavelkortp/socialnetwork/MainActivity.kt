package com.pavelkortp.socialnetwork

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.transition.Slide
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email") ?: ""

        val name = getNameFromEmail(email)
        binding.Name.text = name

        binding.LogOut.setOnClickListener {
            logout()
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
        window.enterTransition = Slide()
        window.exitTransition = Slide()

    }

    private fun getNameFromEmail(email: String): String {
        return email
            .substring(0, email.indexOf('@'))
            .split(Regex("[._]"))
            .joinToString(" ") { e -> e.replaceFirstChar { it.uppercase() } }
    }

    private fun logout() {
        getSharedPreferences(
            "my_app_preferences",
            Context.MODE_PRIVATE
        )
            .edit()
            .clear()
            .apply()
    }

    @Parcelize
    class State(var counter: Int) : Parcelable


}