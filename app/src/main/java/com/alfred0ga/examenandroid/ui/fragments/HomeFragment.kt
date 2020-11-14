package com.alfred0ga.examenandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alfred0ga.examenandroid.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {

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
    }
}