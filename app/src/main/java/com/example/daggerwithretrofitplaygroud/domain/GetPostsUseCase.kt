package com.example.daggerwithretrofitplaygroud.domain

import com.example.daggerwithretrofitplaygroud.data.ApiRepository
import com.example.daggerwithretrofitplaygroud.data.model.Post

class GetPostsUseCase {

    private val repository = ApiRepository()

    suspend operator fun invoke() : List<Post> {
        return repository.getAllPosts()
    }

}