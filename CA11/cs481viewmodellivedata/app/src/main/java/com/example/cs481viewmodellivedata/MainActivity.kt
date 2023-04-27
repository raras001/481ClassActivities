package com.example.cs481viewmodellivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bNoVM).setOnClickListener {
            startActivity(Intent(this, NoViewModel::class.java))
        }

        findViewById<Button>(R.id.bVM).setOnClickListener {
            startActivity(Intent(this, ViewModel::class.java))
        }

        findViewById<Button>(R.id.bLD).setOnClickListener {
            startActivity(Intent(this, LiveData::class.java))
        }

    }
}