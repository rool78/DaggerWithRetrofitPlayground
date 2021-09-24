package com.example.daggerwithretrofitplaygroud.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "philosophers_table")
data class Philosopher(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "quote")
    var quote: String = ""
) {

    override fun toString(): String {
        return "Philosopher(uid=$uid, name='$name', quote='$quote')"
    }
}

