package com.example.myassignmentantinolabs.services

import com.example.myassignmentantinolabs.model.Destination
import retrofit2.Call
import retrofit2.http.GET

interface DestinationService {
//http://demo8716682.mockable.io/cardData
    @GET("cardData")
    fun getDestinationList(): Call<List<Destination>>
}