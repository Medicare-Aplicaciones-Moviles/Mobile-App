package com.caretech.careconnect.models

import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient
import java.io.Serializable
import java.util.Date

data class Appointment(
    val id: Int?,
    val date: String,
    val description: String,
    val doctor_id: Int,
    val patient_id: Int
):Serializable