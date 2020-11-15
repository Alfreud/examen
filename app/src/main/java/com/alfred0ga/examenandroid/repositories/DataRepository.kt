package com.alfred0ga.examenandroid.repositories

import com.alfred0ga.examenandroid.db.EmployeesDatabase
import com.alfred0ga.examenandroid.models.Employee
import com.alfred0ga.examenandroid.network.RetrofitInstance

class DataRepository(
    val db: EmployeesDatabase
) {
    suspend fun getDataFromAPI() = RetrofitInstance.api.getDataFromAPI()

    suspend fun upsert(employee: Employee) = db.getEmployeeDAO().upsert(employee)

    fun getAllDataFromDB() = db.getEmployeeDAO().getAllDataFromDB()
}