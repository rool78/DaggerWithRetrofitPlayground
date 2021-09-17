package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.model.Post
import com.example.daggerwithretrofitplaygroud.data.network.ApiService

class ApiRepository {

    private val api = ApiService()

    suspend fun getAllPosts(): List<Post> {
        return api.getPosts()
    }

}