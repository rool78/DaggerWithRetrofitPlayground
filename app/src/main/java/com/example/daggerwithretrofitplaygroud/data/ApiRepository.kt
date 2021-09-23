package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.data.network.ApiService
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherEntity
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllPhilosophers(): List<Philosopher> {
        return apiService.getPhilosophers()
    }

    suspend fun getAllPhilosophersFromRoom(): List<PhilosopherEntity> {
        return apiService.getPhilosophersFromRoom()
    }

}