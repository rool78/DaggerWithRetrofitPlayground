package com.example.daggerwithretrofitplaygroud.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "philosophers_table")
data class PhilosopherEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "quote")
    var quote: String = ""
)

