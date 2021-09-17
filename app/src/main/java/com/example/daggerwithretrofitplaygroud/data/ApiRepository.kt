package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.model.Post
import com.example.daggerwithretrofitplaygroud.data.network.ApiService
import retrofit2.Retrofit
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

//    private val api = ApiService()

    suspend fun getAllPosts(): List<Post> {
        return apiService.getPosts()
    }

}