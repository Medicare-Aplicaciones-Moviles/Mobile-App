package com.caretech.careconnect.User

import java.io.Serializable

data class Doctor(
    val id: Int,
    val name: String,
    val lastname: String,
    val specialty: String,
    val email: String,
    val password: String,
    val height: Double,
    val weight: Double,
    val bodyMassIndex: Double
):Serializable
