package com.example.cs481viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NoViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_view_model)

        var counter = 0

        findViewById<Button>(R.id.bIncNVM).setOnClickListener {
            counter ++
            findViewById<TextView>(R.id.tvNVM).text = counter.toString()
        }
    }
}