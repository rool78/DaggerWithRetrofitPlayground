package com.example.daggerwithretrofitplaygroud.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "philosophers_table")
data class PhilosopherEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "quote")
    val quote: String
)

