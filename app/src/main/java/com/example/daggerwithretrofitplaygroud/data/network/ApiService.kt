package com.example.daggerwithretrofitplaygroud.data.network

import com.example.daggerwithretrofitplaygroud.core.RetrofitHelper
import com.example.daggerwithretrofitplaygroud.data.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPosts() : List<Post> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<Post>> = retrofit.create(ApiClient::class.java).getAllPosts()
            response.body() ?: emptyList()
        }
    }
}
