package com.example.myassignmentantinolabs.services

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private const val URL = "http://demo8716682.mockable.io/"

    //Create OkHttp Client
    private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder()

    //Create Retrofit Builder
    private val builder:Retrofit.Builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //Create Retrofit Instance
     private val retrofit:Retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }
}