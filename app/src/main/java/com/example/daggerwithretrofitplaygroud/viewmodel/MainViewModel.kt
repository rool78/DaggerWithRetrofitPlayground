package com.example.daggerwithretrofitplaygroud.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.domain.GetRandomPhilosopherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomPhilosopherUseCase: GetRandomPhilosopherUseCase) : ViewModel() {

    val philosophersModel = MutableLiveData<Philosopher>()

    fun getRandomPhilosopher() {
      viewModelScope.launch {
          val result = getRandomPhilosopherUseCase()
          philosophersModel.postValue(result)
      }
    }

}