package com.caretech.careconnect

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caretech.careconnect.Remote.PatientService
import com.caretech.careconnect.User.Patient
import com.caretech.careconnect.adapter.PatientAdapter
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PatientsCitaActivity : AppCompatActivity() {
    lateinit var patients: List<Patient>
    lateinit var patientAdapter: PatientAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patients_cita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSearchPatients = findViewById<Button>(R.id.btSearchClientes)

        btnSearchPatients.setOnClickListener{
            searchPatient()
        }

    }

    private fun searchPatient() {
        val etNombrePaciente = findViewById<TextInputEditText>(R.id.etNombrePaciente)
        val nombrePaciente = etNombrePaciente.text.toString()

        //Instancia de retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Instancia de nuestro service
        val patientService: PatientService = retrofit.create(PatientService::class.java)



    }
}