package com.example.daggerwithretrofitplaygroud.di.module

import com.example.daggerwithretrofitplaygroud.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun testStringProvider() = "This is a string provided by dagger x)"

    @Provides
    @Singleton
    fun provieRetrofit() : Retrofit =
    Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

}