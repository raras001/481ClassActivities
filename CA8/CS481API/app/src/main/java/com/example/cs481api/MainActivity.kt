package com.example.cs481api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cs481api.API.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJsondata()
    }
    private fun getJsondata() {
        val jsondata = retrofitBuilder.getAPIData()
        jsondata.enqueue(object : Callback<List<DataAPIItem>?> {
            override fun onResponse(
                call: Call<List<DataAPIItem>?>,
                response: Response<List<DataAPIItem>?>
            ) {
                val responseReturn = response.body()!!
                for (data in responseReturn){
                    Log.d("APISUCCESS","ID: " + data.id)
                    Log.d("APISUCCESS","Title: " + data.title)
                }

            }
            override fun onFailure(call: Call<List<DataAPIItem>?>, t: Throwable) {
                Log.d("APIFAIL","message" + t.message)
            }
        })
    }
}