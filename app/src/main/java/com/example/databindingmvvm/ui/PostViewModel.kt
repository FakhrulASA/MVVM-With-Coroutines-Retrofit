package com.example.databindingmvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databindingmvvm.network.Api
import com.example.databindingmvvm.coroutine.Coroutines
import com.example.databindingmvvm.data.PostData
import com.example.databindingmvvm.repository.Repository
import kotlinx.coroutines.*

class PostViewModel():ViewModel(){
    var postData:MutableLiveData<PostData> = MutableLiveData()
    private lateinit var job: Job
    fun getPost(){
        var repository: Repository =
            Repository(Api())
        GlobalScope.launch(Dispatchers.Main){
         postData.value= repository.getMovies()
        }
        job= Coroutines.ioThenMain(
            { repository.getMovies() },
            {
                postData.value = it
            }
        )
    }

}