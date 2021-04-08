package com.example.databindingmvvm

class Repository(private val api: Api) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}
