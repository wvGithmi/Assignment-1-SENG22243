package com.example.rest_api.posts.api;

import com.example.rest_api.posts.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsApi {

    @GET("posts")
    Call<List<Posts_Api>> getPost();

}
