package com.alfred0ga.examenandroid.repositories

import com.alfred0ga.examenandroid.network.RetrofitInstance

class DataRepository() {
    suspend fun getDataFromAPI() = RetrofitInstance.api.getDataFromAPI()
}