package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.domain.GetPhilosophersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPhilosophersUseCase: GetPhilosophersUseCase) : ViewModel() {

    val philosophersModel = MutableLiveData<List<Philosopher>>()
//    var getPostsUseCase = GetPostsUseCase()

    fun getPosts() {
      viewModelScope.launch {
          val result = getPhilosophersUseCase()
          philosophersModel.postValue(result)
      }
    }

}