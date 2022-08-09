package com.example.apppushnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apppushnotification.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getStringExtra(EXTRA_DATA)
        binding.txtSample.text = data
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}