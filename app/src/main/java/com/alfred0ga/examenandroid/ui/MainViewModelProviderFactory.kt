package com.alfred0ga.examenandroid.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alfred0ga.examenandroid.repositories.DataRepository

class MainViewModelProviderFactory(
    val app: Application,
    val dataRepository: DataRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, dataRepository) as T
    }
}