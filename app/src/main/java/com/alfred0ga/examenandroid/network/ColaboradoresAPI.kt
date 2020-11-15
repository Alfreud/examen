package com.alfred0ga.examenandroid.network

import com.alfred0ga.examenandroid.models.DataAPI
import retrofit2.Response
import retrofit2.http.GET

interface ColaboradoresAPI {

    @GET("?dl=0")
    suspend fun getDataFromAPI(): Response<DataAPI>
}