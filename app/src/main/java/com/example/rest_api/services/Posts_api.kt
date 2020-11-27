package com.example.rest_api.services

import retrofit2.Call
import com.example.rest_api.models.Post
import retrofit2.http.GET

interface Posts_api {

    @GET("posts")
    fun getPostList () : Call<List<Post>>

}