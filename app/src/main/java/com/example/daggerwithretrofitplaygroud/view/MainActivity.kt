package com.example.daggerwithretrofitplaygroud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerwithretrofitplaygroud.BuildConfig
import com.example.daggerwithretrofitplaygroud.R
import com.example.daggerwithretrofitplaygroud.api.ApiService
import com.example.daggerwithretrofitplaygroud.model.Post
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var mDaggerStringTest: String
    @Inject lateinit var mRetrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("???? Hello? -> $mDaggerStringTest")

        val service = mRetrofit.create<ApiService>(ApiService::class.java)

        service.getAllPosts().enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                val posts = response?.body()
                if (posts != null) {
                    for (post in posts) {
                        println("???? Post -> $post")
                    }
                }
            }
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                println("???? Failure: ${t.toString()}")
            }
        })

    }
}