package com.example.hw_5_5.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw_5_5.remote.LoveApi
import com.example.hw_5_5.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {
    fun getData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val love = MutableLiveData<LoveModel>()

        api.getLove(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        love.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("данные не пришли", "onFailure", )
            }
        })
        return love
    }
}