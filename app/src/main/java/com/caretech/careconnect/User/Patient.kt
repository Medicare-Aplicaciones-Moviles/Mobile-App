package com.caretech.careconnect.User

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
    val body_mass_index: Double
):Serializable
