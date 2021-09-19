package com.example.daggerwithretrofitplaygroud.domain

import com.example.daggerwithretrofitplaygroud.data.ApiRepository
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import javax.inject.Inject

//We want to inject that class on the viewModel
class GetPhilosophersUseCase @Inject constructor(private val repository: ApiRepository){

//    private val repository = ApiRepository()

    suspend operator fun invoke() : List<Philosopher> {
        return repository.getAllPosts()
    }

}