package com.example.daggerwithretrofitplaygroud.data.network

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDao
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ApiService @Inject constructor(
    private val apiClient: ApiClient,
    private val philosopherDao: PhilosopherDao)
{

    //Calling api with coroutine
    suspend fun getPhilosophers() : List<Philosopher> {
        return withContext(Dispatchers.IO) {
            val response: Response<List<Philosopher>> =
                /*retrofit.create(ApiClient::class.java)*/apiClient.getAllPhilosophers()
            response.body() ?: emptyList()
        }
    }

    //TODO Create RoomService to be called from ApiRepository
    suspend fun getPhilosophersFromRoom() : List<PhilosopherEntity> {
        return withContext(Dispatchers.IO) {
            philosopherDao.getAll()
        }
    }
}
