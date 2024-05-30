package com.caretech.careconnect.Remote

import com.caretech.careconnect.User.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PatientService {

    @GET("patients")
    fun getPatients(): Call<List<Patient>>

    @POST("patients/login")
    fun loginPatient(@Body patient: Patient): Call<Patient>

    @PUT("patients/{id}")
    fun updatePatient(@Body patient: Patient, @Path("id") id: Int): Call<Patient>
}