package com.example.cs481api.API

import com.example.cs481api.DataAPIItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("posts")
    fun getAPIData(): Call<List<DataAPIItem>>
}