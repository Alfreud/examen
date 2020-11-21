package com.alfred0ga.examenandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alfred0ga.examenandroid.R
import com.alfred0ga.examenandroid.adapters.EmployeeAdapter
import com.alfred0ga.examenandroid.models.Employee
import com.alfred0ga.examenandroid.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_colaboradores_lista.*

 class ColaboradoresListaFragment : Fragment(R.layout.fragment_colaboradores_lista), EmployeeAdapter.OnItemClickListener {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        generateData()
        viewModel.employees.observe(viewLifecycleOwner, Observer {
            employeeAdapter.submitList(it)
        })
    }

    fun setupRecyclerView() = recycler_view.apply{
        employeeAdapter = EmployeeAdapter(this@ColaboradoresListaFragment)
        adapter = employeeAdapter
    }

    fun generateData() {
        val location1 = Employee.Location("19.300378", "-99.2009822")
        val employee1 = Employee("124", location1, "alejandro@upaxer.com", "Daniel Alejandro Catañeda")
        viewModel.upsert(employee1)

        val location2 = Employee.Location("19.3052213", "-99.2032828")
        val employee2 = Employee("145", location2, "mariela@upaxer.com", "Mariela Duran")
        viewModel.upsert(employee2)

        val location3 = Employee.Location("19.3051679", "-99.2021852")
        val employee3 = Employee("175", location3, "david@upaxer.com", "David Campos")
        viewModel.upsert(employee3)

        val location4 = Employee.Location("19.3054457", "-99.2024085")
        val employee4 = Employee("198", location4, "jesusa@upaxer.com", "Jesus Alejandro Damian")
        viewModel.upsert(employee4)
    }

     override fun onItemClick(position: Employee) {
         val action = ColaboradoresListaFragmentDirections.actionColaboradoresListaFragmentToColaboradoresMapaFragment(position)
         findNavController().navigate(action)
     }
 }