package com.alfred0ga.examenandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alfred0ga.examenandroid.models.Employee

@Database(
    entities = [Employee::class],
    version = 1
)
abstract class EmployeesDatabase(): RoomDatabase() {
    abstract fun getEmployeeDAO(): DataDAO

    companion object {
        @Volatile
        private var instance: EmployeesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                EmployeesDatabase::class.java,
                "employee_db.db"
            ).build()
    }
}