package com.example.databindingmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingmvvm.R
import com.example.databindingmvvm.data.PostData
import com.example.databindingmvvm.data.PostDataItem
import com.example.databindingmvvm.databinding.ItemPostBinding

class PostAdapter(
    private val posts:List<PostDataItem>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    inner class PostViewHolder(
        val itemPostBinding: ItemPostBinding
    ):RecyclerView.ViewHolder(itemPostBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=PostViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
       return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemPostBinding.posts=posts[position]
    }
}