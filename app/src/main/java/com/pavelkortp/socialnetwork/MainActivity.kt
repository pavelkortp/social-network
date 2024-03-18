package com.pavelkortp.socialnetwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavelkortp.socialnetwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var useKeyboard: Boolean = false

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
//
//        binding.useKeyboard.setOnClickListener {
//            this.useKeyboard = binding.useKeyboard.isChecked
//            updateUI()
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
//        binding.ProgressBar.visibility = View.VISIBLE
//        Glide.with(this)
//            .load("https://source.unsplash.com/random/300x200?$encodedKeyword")
//            .skipMemoryCache(true)
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .listener(object :RequestListener<Drawable>{
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    binding.ProgressBar.visibility = View.GONE
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable,
//                    model: Any,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    binding.ProgressBar.visibility = View.GONE
//                    return false
//                }
//            })
//            .into(binding.Pic)
//        return false
//    }
//
//
//    private fun updateUI(){
//        if (useKeyboard){
//            binding.SearchField.visibility = View.VISIBLE
//        }else{
//            binding.SearchField.visibility = View.GONE
//        }
//    }

}