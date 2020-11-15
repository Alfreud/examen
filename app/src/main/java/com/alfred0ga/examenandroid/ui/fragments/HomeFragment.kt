package com.alfred0ga.examenandroid.ui.fragments

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alfred0ga.examenandroid.R
import com.alfred0ga.examenandroid.models.DataAPI
import com.alfred0ga.examenandroid.network.RetrofitInstance
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var myDataAPI: DataAPI
    var myDownloadId: Long = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ver_colaboradores.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColaboradoresListaFragment()
            findNavController().navigate(action)
        }

        agregar_colaboradores.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAgregarColaboradorFragment()
            findNavController().navigate(action)
        }

        val api = RetrofitInstance.api

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getDataFromAPI()
            if (response.isSuccessful) {
                myDataAPI = response.body()!!
                Log.d("hello", myDataAPI.data.file)

                var request = DownloadManager.Request(Uri.parse(myDataAPI.data.file.toString()))
                    .setTitle("myDownload")
                    .setDescription("data from rest API")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                    .setAllowedOverMetered(true)

                var dm = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                myDownloadId = dm.enqueue(request)

                var br = object: BroadcastReceiver() {
                    override fun onReceive(p0: Context?, p1: Intent?) {
                        var id = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                        if (id == myDownloadId) {
                            Toast.makeText(activity, "download completed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                activity?.registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
            }
        }

    }
}