package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerwithretrofitplaygroud.data.model.Post
import com.example.daggerwithretrofitplaygroud.domain.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    val postsModel = MutableLiveData<List<Post>>()
//    var getPostsUseCase = GetPostsUseCase()

    fun getPosts() {
      viewModelScope.launch {
          val result = getPostsUseCase()
          postsModel.postValue(result)
      }
    }

}