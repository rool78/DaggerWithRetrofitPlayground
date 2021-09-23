package com.example.daggerwithretrofitplaygroud.di.module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.daggerwithretrofitplaygroud.BuildConfig
import com.example.daggerwithretrofitplaygroud.data.network.ApiClient
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDao
import com.example.daggerwithretrofitplaygroud.data.room.PhilosopherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
    Retrofit.Builder()
    .baseUrl(BuildConfig.API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    //Room
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context) : PhilosopherDatabase {
        return Room.databaseBuilder(
            applicationContext,
            PhilosopherDatabase::class.java,
            "philosophers_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePhilosopherDao(philosopherDatabase: PhilosopherDatabase) : PhilosopherDao {
        return philosopherDatabase.philosopherDao
    }

}