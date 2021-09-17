package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerwithretrofitplaygroud.data.model.Post
import com.example.daggerwithretrofitplaygroud.domain.GetPostsUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val postsModel = MutableLiveData<List<Post>>()
    var getPostsUseCase = GetPostsUseCase()


    fun getPosts() {
      viewModelScope.launch {
          val result = getPostsUseCase()
          postsModel.postValue(result)
      }
    }

}