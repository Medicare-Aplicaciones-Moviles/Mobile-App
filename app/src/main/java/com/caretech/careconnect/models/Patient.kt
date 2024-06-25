package com.caretech.careconnect.User

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Patient(
    val id: Int,
    val name: String,
    val lastname: String,
    val age: Int,
    val email: String,
    val password: String,
    val height: Double,
    val weight: Double,
    val body_mass_index: Double,
    @SerializedName("fecha_nacimiento") val fecha_nacimiento: String,
    val telefono: String,
    @SerializedName("profile_image") val profileImage: String
):Serializable