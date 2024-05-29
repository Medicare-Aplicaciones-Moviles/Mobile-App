package com.caretech.careconnect.models

import com.google.gson.annotations.SerializedName

class Doctor(
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("speciality")
    val photo: String,
    val speciality: String,
    val calification: Float,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    val appointmentPrice : Float
)