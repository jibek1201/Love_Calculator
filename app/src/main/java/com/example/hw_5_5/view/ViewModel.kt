package com.example.hw_5_5.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_5_5.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

        fun getLiveLoveData(firstName:String, secondName:String):LiveData<LoveModel>{
            return repository.getData(firstName, secondName)
        }
    }