package com.example.daggerwithretrofitplaygroud.data.room

import androidx.room.*

@Dao
interface PhilosopherDao {
    @Query("SELECT * FROM philosophers_table")
    suspend fun getAll(): List<PhilosopherEntity>

    @Query("SELECT * FROM philosophers_table WHERE uid IN (:philosopherEntityIds)")
    suspend fun loadAllByIds(philosopherEntityIds: IntArray): List<PhilosopherEntity>

    @Insert
    suspend fun insertAll(vararg users: PhilosopherEntity)

    @Update
    suspend fun update(philosopherEntity: PhilosopherEntity)

    @Delete
    suspend fun delete(user: PhilosopherEntity)
}
