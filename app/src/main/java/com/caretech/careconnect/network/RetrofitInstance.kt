package com.caretech.careconnect.Remote

import com.caretech.careconnect.network.CitaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://medicare.fly.dev/"

    val ApiDoctor: DoctorService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DoctorService::class.java)
    }

    val ApiPatient : PatientService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PatientService::class.java)
    }

    val ApiAppointment : CitaService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CitaService::class.java)
    }
}