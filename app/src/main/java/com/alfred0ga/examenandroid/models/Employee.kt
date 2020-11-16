package com.alfred0ga.examenandroid.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val location: Location,
    val mail: String,
    val name: String
) : Parcelable {

    @Parcelize
    data class Location(
        var lat: String,
        var log: String
    ) : Parcelable
}