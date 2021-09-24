package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.network.ApiService
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.data.room.DatabaseService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService,
    private val databaseService: DatabaseService
) {

    suspend fun getAllPhilosophers(): List<Philosopher> {
        return apiService.getPhilosophers()
    }

    suspend fun getAllPhilosophersFromDatabase(): List<Philosopher> {
        return databaseService.getAllPhilosophers()
    }

}