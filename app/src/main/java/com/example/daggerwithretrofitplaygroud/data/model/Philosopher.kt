package com.example.daggerwithretrofitplaygroud.data.model

data class Philosopher(
    private var id:Int,
    private var name:String,
    private var quote:String
) {

    override fun toString(): String {
        return "Philosopher(id=$id, name='$name', quote='$quote')"
    }

}