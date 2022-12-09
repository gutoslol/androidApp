package com.example.androidapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.androidapp.XORCryptor

object ServiceBuilder {
    var client = OkHttpClient.Builder().build()

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://augustotesser1515.xyz/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>) : T {
        return retrofit.create(service)
    }

    fun dicript (streng: String, queis: String): String {
        return XORCryptor.processBytes(streng.toByteArray(), queis.toByteArray()).toString()
    }

}