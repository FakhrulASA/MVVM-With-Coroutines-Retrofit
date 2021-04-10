package com.example.databindingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class PostViewModel():ViewModel(){
    var postData:MutableLiveData<PostData> = MutableLiveData()
    private lateinit var job: Job
    fun getPost(){
        var repository:Repository= Repository(Api())
        GlobalScope.launch(Dispatchers.Main){
         postData.value= repository.getMovies()
        }
        job=Coroutines.ioThenMain(
            {repository.getMovies()},
            {
                postData.value=it
            }
        )
    }

}