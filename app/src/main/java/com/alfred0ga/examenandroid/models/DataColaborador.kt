package com.alfred0ga.examenandroid.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataColaborador(
    val code: Int,
    val data: Data,
    val success: Boolean
) : Parcelable {

    @Parcelize
    data class Data(
        val file: String
    ) : Parcelable
}