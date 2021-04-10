package com.example.databindingmvvm.repository

import com.example.databindingmvvm.network.Api
import com.example.databindingmvvm.util.SafeApiRequest

class Repository(private val api: Api) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}
