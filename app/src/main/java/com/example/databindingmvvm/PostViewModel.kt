package com.example.databindingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostViewModel():ViewModel(){
    var postData:MutableLiveData<PostData> = MutableLiveData()
    fun getPost(){
        var repository:Repository= Repository(Api())
        GlobalScope.launch(Dispatchers.Main){
         postData.value= repository.getMovies()
        }
    }

}