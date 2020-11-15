package com.alfred0ga.examenandroid.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val location: Location,
    val mail: String,
    val name: String
) : Parcelable {

    @Parcelize
    data class Location(
        val lat: String,
        val log: String
    ) : Parcelable
}