package com.example.daggerwithretrofitplaygroud.data.room

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import javax.inject.Inject

class DatabaseService @Inject constructor(private val philosopherDao: PhilosopherDao) {

    suspend fun getAllPhilosophers() : List<Philosopher> {
        return philosopherDao.getAll()
    }
}