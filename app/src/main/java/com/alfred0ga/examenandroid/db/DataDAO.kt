package com.alfred0ga.examenandroid.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alfred0ga.examenandroid.models.Employee

@Dao
interface DataDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(employee: Employee)

    @Query("SELECT * FROM employees")
    fun getAllDataFromDB(): LiveData<List<Employee>>
}