package com.example.daggerwithretrofitplaygroud.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher

@Database(entities = [Philosopher::class], version = 1, exportSchema = false)
abstract class PhilosopherDatabase : RoomDatabase() {

    abstract val philosopherDao: PhilosopherDao

    companion object {
        @Volatile
        private var INSTANCE: PhilosopherDatabase? = null

        fun getInstance(context: Context): PhilosopherDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhilosopherDatabase::class.java,
                        "philosophers_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
