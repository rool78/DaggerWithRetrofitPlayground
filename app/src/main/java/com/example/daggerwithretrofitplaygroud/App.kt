package com.example.daggerwithretrofitplaygroud

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.room.Room
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDatabase
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherEntity
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.Executors

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        val datasource = PhilosopherDatabase.getInstance(this).philosopherDao

        Executors.newSingleThreadExecutor().execute {
            datasource.insert(PhilosopherEntity(name = "Rool", quote = "dfskfm"))
            val data = datasource.getAll()
            println("???? data: $data")
        }


    }
}