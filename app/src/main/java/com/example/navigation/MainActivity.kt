package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.model.Artist

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var artistList = ArrayList<Artist>()
}