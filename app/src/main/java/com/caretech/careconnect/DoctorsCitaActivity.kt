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
import com.caretech.careconnect.Remote.RetrofitInstance
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient
import com.caretech.careconnect.adapter.DoctorAdapter
import com.caretech.careconnect.network.CitaService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DoctorsCitaActivity : AppCompatActivity() {
    lateinit var doctors: List<Doctor>
    lateinit var doctorAdapter: DoctorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors_cita)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSearch = findViewById<Button>(R.id.btSearchDoctores)
        val patient = intent.getSerializableExtra("patient") as Patient

        btnSearch.setOnClickListener{
            searchDoctor()
        }

        RetrofitInstance.ApiDoctor.getDoctors().enqueue(object : Callback<List<Doctor>> {
            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                val rvDoctor = findViewById<RecyclerView>(R.id.rvDoctores)
                doctors = response.body()!!
                doctorAdapter = DoctorAdapter(doctors, patient)
                rvDoctor.adapter = doctorAdapter
                rvDoctor.layoutManager = LinearLayoutManager(this@DoctorsCitaActivity)
            }

            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })
    }

    private fun searchDoctor() {

        val etNombreDoctor = findViewById<TextInputEditText>(R.id.etSearchNombreDoctor)
        val nombreDoctor = etNombreDoctor.text.toString()
        val patient = intent.getSerializableExtra("patient") as Patient
        //Instancia de retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //Instancia de nuestro service
        val citaService: CitaService = retrofit.create(CitaService::class.java)

        val request = citaService.searchDoctor(nombreDoctor)

        request.enqueue(object : Callback<List<Doctor>>{
            override fun onResponse(p0: Call<List<Doctor>>, p1: Response<List<Doctor>>) {
                val rvDoctor = findViewById<RecyclerView>(R.id.rvDoctores)
                doctors = p1.body()!!
                doctorAdapter = DoctorAdapter(doctors,patient )
                rvDoctor.adapter = doctorAdapter
                rvDoctor.layoutManager = LinearLayoutManager(this@DoctorsCitaActivity)
            }

            override fun onFailure(p0: Call<List<Doctor>>, p1: Throwable) {
                Log.e("Error", p1.message.toString())
            }

        })
    }
}