package com.caretech.careconnect.network

import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.models.Appointment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CitaService {
    @GET("")
    fun searchDoctor(@Query("") fetchAll: String): Call<List<Doctor>>

    @POST("appointments")
    fun createAppointment(@Body appointment: Appointment): Call<Appointment>
}