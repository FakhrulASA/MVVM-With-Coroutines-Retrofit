package com.example.databindingmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.databindingmvvm.network.Api
import com.example.databindingmvvm.R
import com.example.databindingmvvm.repository.Repository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository =
            Repository(Api())
        val model: PostViewModel by viewModels()

        model.getPost()
            model.postData.observe(
                this@MainActivity,
                Observer {

                    Log.d("HALA", it.get(2).title)
                })
    }
}