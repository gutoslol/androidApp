package com.example.androidapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostInterface {
    @POST("/api1")
    fun sendReq(@Body list: ArrayList<ContactModel>): Call<ContactModel>

}