package com.example.rest_api.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object Postsapi {

    private val http = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(http.build())

    private val retrofit = builder.build()

    fun <T> buildPost (postType :Class<T>):T{
        return retrofit.create(postType)
    }

}