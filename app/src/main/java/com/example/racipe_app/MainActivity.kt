package com.example.racipe_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.racipe_app.Fragments.Splash_Fragment
import com.example.racipe_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        }
    }

