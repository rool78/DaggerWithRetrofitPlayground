package com.example.daggerwithretrofitplaygroud

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.room.Room
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDao
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDatabase
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherEntity
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltAndroidApp
class App: Application()