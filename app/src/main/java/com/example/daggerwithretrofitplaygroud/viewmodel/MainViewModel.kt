package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerwithretrofitplaygroud.BuildConfig
import com.example.daggerwithretrofitplaygroud.api.ApiService
import com.example.daggerwithretrofitplaygroud.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val postsModel = MutableLiveData<List<Post>>()

    fun fetchPosts() {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create<ApiService>(ApiService::class.java)

        service.getAllPosts().enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                val posts = response?.body()
                   postsModel.postValue(posts!!)
            }
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                println("???? Failure: ${t.toString()}")
            }
        })
    }


}