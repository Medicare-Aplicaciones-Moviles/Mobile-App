package com.caretech.careconnect.network

import com.caretech.careconnect.models.Patient
import com.caretech.careconnect.models.PatientRequestInEditInformation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query

interface PatientService {
    @GET("patient-controller")
    fun searchPatient(@Query("fetchAll") fetchAll: String): Call<List<Patient>>

    @GET("patient-controller")
    fun getPatientById(@Query("fetchById") fetchById: String): Call<Patient>

    //Para mostrar los datos en la vista de activity_patient_view_profile(Nombre, Apellido, Fecha de Nacimiento, Telefono, Photo)
    @GET("patient-controller")
    fun getPersonalInformationToViewProfile(@Query("fetchPersonalInformation") fetchPersonalInformation: String ): Call<Patient>

    //Para cambiar la vista de activity_patient_edit_personal_information(Nombre, Apellido, Fecha de Nacimiento, Telefono, Altura, Peso, Masa, Photo)
    @PATCH("patient-controller")
    fun updatePersonalInformation(@Body patientPersonalInformation: PatientRequestInEditInformation): Call<Patient>
}