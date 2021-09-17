package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerwithretrofitplaygroud.core.RetrofitHelper
import com.example.daggerwithretrofitplaygroud.data.model.Post
import com.example.daggerwithretrofitplaygroud.data.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainViewModel : ViewModel() {

    val postsModel = MutableLiveData<List<Post>>()
    private val retrofit = RetrofitHelper.getRetrofit()


    fun onCreate() {
//        viewModelScope.launch {
//            val result = test()
//            postsModel.postValue(result)
        }

}