package com.alfred0ga.examenandroid.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.alfred0ga.examenandroid.R
import com.alfred0ga.examenandroid.models.DataAPI
import com.alfred0ga.examenandroid.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var myDataAPI: DataAPI
    var myDownloadId: Long = 0

    @RequiresApi(Build.VERSION_CODES.O)
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

        /*val api = RetrofitInstance.api

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getDataFromAPI()
            if (response.isSuccessful) {
                myDataAPI = response.body()!!
                Log.d("hello", myDataAPI.data.file)

                var request = DownloadManager.Request(Uri.parse(myDataAPI.data.file.toString()))
                    .setTitle("myDownload.zip")
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
        }*/


        /*var zipFileName= "hola"
        val filename = uri.getLastPathSegment()

        ProcessBuilder()
            .command("unzip", zipFileName)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()*/

        //val filePath = Environment.DIRECTORY_DOWNLOADS
        //val myFile = File("myDownload")

        //ZipUtilities.unzipResource(filePath, myFile)
    }
}