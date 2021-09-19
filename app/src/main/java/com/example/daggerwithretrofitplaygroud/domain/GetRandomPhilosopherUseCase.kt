package com.example.daggerwithretrofitplaygroud.domain

import com.example.daggerwithretrofitplaygroud.data.ApiRepository
import com.example.daggerwithretrofitplaygroud.data.PhilosophersProvider
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import javax.inject.Inject

//We want to inject that class on the viewModel
class GetRandomPhilosopherUseCase @Inject constructor(
    private val repository: ApiRepository,
    private val philosophersProvider: PhilosophersProvider){

//    private val repository = ApiRepository()

    suspend operator fun invoke() : Philosopher {
        if (philosophersProvider.philosophers.isEmpty()) {
            philosophersProvider.philosophers = repository.getAllPosts()
        }
        val random = (philosophersProvider.philosophers.indices).random()
        return philosophersProvider.philosophers[random]
    }
}