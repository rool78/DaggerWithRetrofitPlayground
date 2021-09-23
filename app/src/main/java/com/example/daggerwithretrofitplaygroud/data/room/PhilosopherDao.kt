package com.example.daggerwithretrofitplaygroud.data.room

import androidx.room.*

@Dao
interface PhilosopherDao {
    @Query("SELECT * FROM philosophers_table")
    suspend fun getAll(): List<PhilosopherEntity>

    @Query("SELECT * FROM philosophers_table WHERE uid IN (:philosopherEntityIds)")
    fun loadAllByIds(philosopherEntityIds: IntArray): List<PhilosopherEntity>

    @Insert
    suspend fun insert(philosopherEntity: PhilosopherEntity)

    @Insert
    fun insertAll(philosophers: List<PhilosopherEntity>)

    @Update
    fun update(philosopherEntity: PhilosopherEntity)

    @Delete
    fun delete(philosopherEntity: PhilosopherEntity)
}
