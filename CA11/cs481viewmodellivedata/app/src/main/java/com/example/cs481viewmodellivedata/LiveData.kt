package com.example.cs481viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class LiveData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val viewModel = ViewModelProvider(this).get(LDClass::class.java)

        viewModel.counter.observe(this) {
            findViewById<TextView>(R.id.tvLD).text = it.toString()
        }

        findViewById<Button>(R.id.bIncLD).setOnClickListener {
            viewModel.incNumber()
        }

    }
}