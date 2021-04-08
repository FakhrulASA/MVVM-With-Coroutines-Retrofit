package com.example.databindingmvvm

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getMovies():Response<PostData>

    companion object{
        operator fun invoke():Api{

             return Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .baseUrl("https://jsonplaceholder.typicode.com/")
                 .build()
                 .create(Api::class.java)
        }
        private val gson: Gson by lazy {
            GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create()
        }
    }
}