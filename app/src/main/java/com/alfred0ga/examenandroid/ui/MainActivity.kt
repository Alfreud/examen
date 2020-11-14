package com.alfred0ga.examenandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfred0ga.examenandroid.R
import com.alfred0ga.examenandroid.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.api

        GlobalScope.launch(Dispatchers.IO) {
            api.getDataFromAPI()
        }
    }
}