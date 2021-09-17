package com.example.daggerwithretrofitplaygroud.domain

import com.example.daggerwithretrofitplaygroud.data.ApiRepository
import com.example.daggerwithretrofitplaygroud.data.model.Post
import retrofit2.Retrofit
import javax.inject.Inject

//We want to inject that class on the viewModel
class GetPostsUseCase @Inject constructor(private val repository: ApiRepository){

//    private val repository = ApiRepository()

    suspend operator fun invoke() : List<Post> {
        return repository.getAllPosts()
    }

}