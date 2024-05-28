package com.caretech.careconnect.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class Patient(
    @SerializedName("name")
    val nombre: String,
    @SerializedName("lastname")
    val apellido: String,
    @SerializedName("age")
    val edad: Int,
    var fechaDeNacimiento: LocalDate,
    var telefono: String,
    var altura: Float,
    var peso: Float,
    var masaCorporal: Float,
    var photo: String,
    @SerializedName("email")
    var correo: String,
    @SerializedName("password")
    var contrasena: String,
    )

data class PatientRequestInEditInformation(
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val telefono: String,
    val altura: Float,
    val peso: Float,
    val masaCorporal: Float,
    val foto: String
)

