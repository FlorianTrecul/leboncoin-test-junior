package com.floriantrecul.leboncointestjunior.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.floriantrecul.leboncointestjunior.R
import com.floriantrecul.leboncointestjunior.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}