package com.alfred0ga.examenandroid.ui

import android.app.Application
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alfred0ga.examenandroid.models.DataAPI
import com.alfred0ga.examenandroid.repositories.DataRepository
import kotlinx.coroutines.launch

class MainViewModel(
    app: Application,
    val dataRepository: DataRepository
) : AndroidViewModel(app) {
    private val context = getApplication<Application>().applicationContext
    private lateinit var myDataAPI: DataAPI
    var myDownloadId: Long = 0

    init {
        downloadFile()
    }

    fun downloadFile() = viewModelScope.launch {
        val response = dataRepository.getDataFromAPI()
        if (response.isSuccessful) {
            myDataAPI = response.body()!!
            Log.d("hello", myDataAPI.data.file)

            var request = DownloadManager.Request(Uri.parse(myDataAPI.data.file.toString()))
                .setTitle("myDownload.zip")
                .setDescription("data from rest API")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)

            var dm = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            myDownloadId = dm.enqueue(request)

            var br = object : BroadcastReceiver() {
                override fun onReceive(p0: Context?, p1: Intent?) {
                    var id = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                    if (id == myDownloadId) {
                        Toast.makeText(context, "download completed", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            context?.registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
    }
}