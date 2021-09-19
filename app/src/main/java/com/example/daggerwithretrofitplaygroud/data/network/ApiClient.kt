package com.example.daggerwithretrofitplaygroud.data.network

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("philosophers/")
    suspend fun getAllPhilosophers(): Response<List<Philosopher>>

//    @GET("posts/{id}")
//    fun getPostById(@Path("id") id: Int): Call<Post>
}