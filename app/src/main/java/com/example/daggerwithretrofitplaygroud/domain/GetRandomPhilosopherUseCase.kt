package com.example.daggerwithretrofitplaygroud.domain

import android.util.Log
import com.example.daggerwithretrofitplaygroud.data.ApiRepository
import com.example.daggerwithretrofitplaygroud.data.PhilosophersProvider
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import javax.inject.Inject

class GetRandomPhilosopherUseCase @Inject constructor(
    private val repository: ApiRepository,
    private val philosophersProvider: PhilosophersProvider){

    suspend operator fun invoke() : Philosopher {
        Log.d("????", "Quick room test")
        val roomData = repository.getAllPhilosophersFromDatabase()
        Log.d("????", "Room data-> $roomData")

        if (philosophersProvider.philosophers.isEmpty()) {
            Log.d("????", "performing api call")
            philosophersProvider.philosophers = repository.getAllPhilosophers()
        }
        val random = (philosophersProvider.philosophers.indices).random()
        return philosophersProvider.philosophers[random]
    }
}