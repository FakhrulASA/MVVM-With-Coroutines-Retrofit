package com.example.databindingmvvm

import retrofit2.Response
import java.io.IOException
import java.lang.invoke.CallSite

abstract class SafeApiRequest {
    suspend fun <T> apiRequest(call:suspend ()->Response<T>):T{
        val response=call.invoke()
        if(response.isSuccessful)
        {
            return response.body()!!
        }
        else{
            throw APIException(response.code().toString())

        }
    }
}
class APIException(message:String):IOException(message)