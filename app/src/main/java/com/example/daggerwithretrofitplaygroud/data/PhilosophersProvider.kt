package com.example.daggerwithretrofitplaygroud.data

import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhilosophersProvider @Inject constructor() {

    var philosophers: List<Philosopher> = emptyList()

}