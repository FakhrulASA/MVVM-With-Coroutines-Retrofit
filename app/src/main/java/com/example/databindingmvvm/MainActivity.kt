package com.example.databindingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository(Api())
        val model: PostViewModel by viewModels()

        model.getPost()
            model.postData.observe(
                this@MainActivity,
                Observer {

                    Log.d("HALA", it.get(2).title)
                })
    }
}