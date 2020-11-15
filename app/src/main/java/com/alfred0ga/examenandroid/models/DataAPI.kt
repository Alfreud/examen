package com.alfred0ga.examenandroid.models

data class DataAPI(
    val code: Int,
    var data: Data,
    val success: Boolean
) {

    data class Data(
        var file: String
    )
}