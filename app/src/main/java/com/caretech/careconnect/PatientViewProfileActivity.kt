package com.caretech.careconnect

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.caretech.careconnect.Remote.PatientService
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Locale

class PatientViewProfileActivity : AppCompatActivity() {

    private var patient: Patient? = null
    private var doctor: Doctor? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_view_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        patient = intent.getSerializableExtra("patient") as? Patient
        doctor = intent.getSerializableExtra("doctor") as? Doctor

        val tvFecha = findViewById<TextView>(R.id.tvFecha)
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvApellido = findViewById<TextView>(R.id.tvApellido)
        val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
        val ivFoto = findViewById<ImageView>(R.id.ivFoto)

        if(patient == null) {
            tvNombre.text = doctor?.name
            tvApellido.text = doctor?.lastname
            tvFecha.text = doctor?.puntuation
            tvTelefono.text = doctor?.costo
            Glide.with(this)
                .load(patient?.profileImage)
                .into(ivFoto)

        }
        else{
            tvNombre.text = patient?.name
            tvApellido.text = patient?.lastname
            tvFecha.text = patient?.fecha_nacimiento
            tvTelefono.text = patient?.telefono
            Glide.with(this)
                .load(patient?.profileImage)
                .into(ivFoto)
        }





        //BtnLeerInfoPersonal
        val btnLeerInfoPersonal = findViewById<Button>(R.id.btLeerInfoPersonal)

        btnLeerInfoPersonal.setOnClickListener {
            val intent = Intent(this, PatientEditPersonalInformationActivity::class.java)
            intent.putExtra("patient", patient)
            startActivityForResult(intent, EDIT_PERSONAL_INFO_REQUEST_CODE)
        }



        //BtnEdit
        val btnEdit = findViewById<ImageButton>(R.id.ibEdit)
        btnEdit.setOnClickListener {
            val intent = Intent(this, PatientEditPersonalInformationActivity::class.java)
            startActivity(intent)
        }

        //BtnHistorialMedico
        val btnHistorialMedico = findViewById<Button>(R.id.btLeerHMedico)
        btnHistorialMedico.setOnClickListener {
            val intent = Intent(this, HistorialMedicoActivity::class.java)
            startActivity(intent)
        }


        //BotonBack
        val btnBack = findViewById<ImageButton>(R.id.ibBackWhite)

        btnBack.setOnClickListener {
            val intent = Intent(this, PatientMenuActivity::class.java)
            startActivity(intent)
        }

        //BtnActualizar
        val btnActualizar = findViewById<ImageButton>(R.id.ibPerfil)
        btnActualizar.setOnClickListener {
        }

        val btnCerrarSesionEnPerfil = findViewById<Button>(R.id.btnCerrarSesionEnPerfil)
        btnCerrarSesionEnPerfil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val ibInicio = findViewById<ImageButton>(R.id.ibInicio)
        ibInicio.setOnClickListener {
            val intent = Intent(this, PatientMenuActivity::class.java)
            intent.putExtra("patient", patient)
            startActivity(intent)
        }

    }

    companion object {
        private const val EDIT_PERSONAL_INFO_REQUEST_CODE = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_PERSONAL_INFO_REQUEST_CODE && resultCode == RESULT_OK) {
            val updatedPatient = data?.getSerializableExtra("patient") as? Patient
            if (updatedPatient != null) {
                patient = updatedPatient
                val tvNombre = findViewById<TextView>(R.id.tvNombre)
                val tvApellido = findViewById<TextView>(R.id.tvApellido)
                val tvFecha = findViewById<TextView>(R.id.tvFecha)
                val tvTelefono = findViewById<TextView>(R.id.tvTelefono)
                val ivFoto = findViewById<ImageView>(R.id.ivFoto)

                tvNombre.text = updatedPatient.name
                tvApellido.text = updatedPatient.lastname
                tvFecha.text = updatedPatient.fecha_nacimiento
                tvTelefono.text = updatedPatient.telefono
                Glide.with(this)
                    .load(updatedPatient.profileImage)
                    .into(ivFoto)
            }
        }
    }
}