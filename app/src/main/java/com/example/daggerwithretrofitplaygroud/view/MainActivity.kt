package com.example.daggerwithretrofitplaygroud.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.daggerwithretrofitplaygroud.data.model.Philosopher
import com.example.daggerwithretrofitplaygroud.databinding.ActivityMainBinding
import com.example.daggerwithretrofitplaygroud.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.philosophersModel.observe(this, Observer { philosopher ->
            Log.d("????", "viewModel value observed -> $philosopher")
            binding.tvPhilosopher.text = philosopher.name
            binding.tvQuote.text = philosopher.quote
        })

        binding.btCheckItOut.setOnClickListener() {
            mainViewModel.getRandomPhilosopher()
        }
    }
}