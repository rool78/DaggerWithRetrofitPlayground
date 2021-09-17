package com.example.daggerwithretrofitplaygroud.data.network

import com.example.daggerwithretrofitplaygroud.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient){

//     var retrofit : Retrofit

    //Calling api with coroutine
    suspend fun getPosts() : List<Post> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<Post>> =
                /*retrofit.create(ApiClient::class.java)*/apiClient.getAllPosts()
            response.body() ?: emptyList()
        }
    }
}
