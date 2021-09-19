package com.example.daggerwithretrofitplaygroud.data.model

data class Philosopher(
    val id:Int,
    val name:String,
    val quote:String
) {

    override fun toString(): String {
        return "Philosopher(id=$id, name='$name', quote='$quote')"
    }

}