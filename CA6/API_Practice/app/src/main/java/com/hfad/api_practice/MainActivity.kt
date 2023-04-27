package com.hfad.api_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.api.API.APIInterface
import retrofit2.Call
import


class MainActivity : AppCompatActivity() {
    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseURL("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}