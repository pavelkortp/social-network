package com.pavelkortp.socialnetwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.SearchBTN.setOnClickListener {
//            searchImg()
//        }
//
//        binding.SearchField.setOnEditorActionListener { _, actionId, _ ->
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                return@setOnEditorActionListener searchImg()
//            }
//            return@setOnEditorActionListener false
//        }

    }

//    private fun searchImg(): Boolean {
//        val keyword: String = binding.SearchField.text.toString()
//
//        if (keyword.isBlank()) {
//            binding.SearchField.error = "Keyword is empty"
//            return true
//        }
//
//        val encodedKeyword: String = URLEncoder.encode(keyword, StandardCharsets.UTF_8.name())
//
//        Glide.with(this)
//            .load("https://source.unsplash.com/random/300x200?$encodedKeyword")
//            .skipMemoryCache(true)
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .placeholder(R.drawable.bob)
//            .into(binding.Pic)
//        return false
//    }


}