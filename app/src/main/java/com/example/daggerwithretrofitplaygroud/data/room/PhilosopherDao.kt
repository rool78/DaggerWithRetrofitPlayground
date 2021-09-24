package com.example.daggerwithretrofitplaygroud.data.room

import androidx.room.*
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher

@Dao
interface PhilosopherDao {
    @Query("SELECT * FROM philosophers_table")
    suspend fun getAll(): List<Philosopher>

    @Query("SELECT * FROM philosophers_table WHERE uid IN (:philosopherEntityIds)")
    fun loadAllByIds(philosopherEntityIds: IntArray): List<Philosopher>

    @Insert
    suspend fun insert(philosopher: Philosopher)

    @Insert
    fun insertAll(philosophers: List<Philosopher>)

    @Update
    fun update(philosopher: Philosopher)

    @Delete
    fun delete(philosopher: Philosopher)
}
