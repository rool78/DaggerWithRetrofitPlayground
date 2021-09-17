package com.example.daggerwithretrofitplaygroud.data.network

import com.example.daggerwithretrofitplaygroud.data.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {

    @GET("posts/")
    suspend fun getAllPosts(): Response<List<Post>>

//    @GET("posts/{id}")
//    fun getPostById(@Path("id") id: Int): Call<Post>
}