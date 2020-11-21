package com.alfred0ga.examenandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.alfred0ga.examenandroid.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_colaboradores_mapa.*

class ColaboradoresMapaFragment : Fragment(R.layout.fragment_colaboradores_mapa) {
    private var map: GoogleMap? = null
    private val args by navArgs<ColaboradoresMapaFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView?.onCreate(savedInstanceState)
        mapView.getMapAsync { map ->
            val pos = LatLng((args.employee.location.lat).toDouble(), (args.employee.location.log).toDouble())
            map.addMarker(MarkerOptions().position(pos))
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15.0f))
        }
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }



}