package com.example.cs481viewmodellivedata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ViewModel : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val viewModel = ViewModelProvider(this).get(VMClass::class.java)

        findViewById<TextView>(R.id.tvVM).text=viewModel.counter.toString()

        findViewById<Button>(R.id.bIncVM).setOnClickListener {
            viewModel.incNumber()
            findViewById<TextView>(R.id.tvVM).text=viewModel.counter.toString()
        }
    }
}