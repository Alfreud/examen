package com.alfred0ga.examenandroid.models

import androidx.room.TypeConverter
import com.alfred0ga.examenandroid.models.Employee.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromlocation(location: Location): String {
        val gson = Gson()
        return gson.toJson(location)
    }

    @TypeConverter
    fun fromString(value: String): Location {
        val location = object : TypeToken<Location>() {}.type
        return Gson().fromJson(value, location)
    }
}