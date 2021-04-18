package com.example.databindingmvvm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingmvvm.R
import com.example.databindingmvvm.adapter.PostAdapter
import com.example.databindingmvvm.network.Api
import com.example.databindingmvvm.repository.Repository

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository =
            Repository(Api())
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val model: PostViewModel by viewModels()

        model.getPost()
        model.postData.observe(
            this@MainActivity,
            Observer { posts ->
                recyclerView.also {
                    it.layoutManager = LinearLayoutManager(this)
                    it.setHasFixedSize(true)
                    it.adapter = PostAdapter(posts)
                }

            })
    }
}