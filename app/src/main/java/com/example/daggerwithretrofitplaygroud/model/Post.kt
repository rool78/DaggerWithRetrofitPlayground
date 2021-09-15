package com.example.daggerwithretrofitplaygroud.model

class Post(
    private var id:Int,
    private var userId:Int,
    private var title:String,
    private var body:String
) {
    override fun toString(): String {
        return "Post(id=$id, userId=$userId, title='$title', body='$body')"
    }
}