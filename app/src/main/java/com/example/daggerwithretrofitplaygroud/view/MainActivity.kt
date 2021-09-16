package com.example.daggerwithretrofitplaygroud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.daggerwithretrofitplaygroud.BuildConfig
import com.example.daggerwithretrofitplaygroud.R
import com.example.daggerwithretrofitplaygroud.api.ApiService
import com.example.daggerwithretrofitplaygroud.databinding.ActivityMainBinding
import com.example.daggerwithretrofitplaygroud.model.Post
import com.example.daggerwithretrofitplaygroud.viewmodel.MainViewModel
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
//    @Inject lateinit var mRetrofit: Retrofit

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.postsModel.observe(this, Observer { posts ->
            println("???? post model obsesrver")
            for (post in posts) {
                println("???? post -> $post")
            }
        })

        binding.tvMainLabel.setOnClickListener {
            println("???? onClick tv")
            mainViewModel.fetchPosts()
        }
        getPosts()



    }

    fun getPosts() {
        println("???? Hello? -> $mDaggerStringTest")
    }
}