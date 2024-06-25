package com.caretech.careconnect.Remote

import com.caretech.careconnect.User.Doctor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DoctorService {

    @GET("doctors")
    fun getDoctors(): Call<List<Doctor>>

    @POST("doctors/login")
    fun loginDoctor(@Body doctor: Doctor): Call<Doctor>

    @POST("doctors")
    fun registerDoctor(@Body doctor: Doctor): Call<Doctor>
}