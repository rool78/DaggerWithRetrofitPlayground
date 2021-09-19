package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.data.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

//    private val api = ApiService()

    suspend fun getAllPosts(): List<Philosopher> {
        return apiService.getPosts()
    }

}