package com.caretech.careconnect

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.caretech.careconnect.Remote.RetrofitInstance
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call

class IngresarDatosRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingresar_datos_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val option = intent.getStringExtra("opcion")

        //Boton back
        val btnBack = findViewById<ImageButton>(R.id.ibBack)

        btnBack.setOnClickListener {
            val intent = Intent(this, RolInteractivityRegister::class.java)
            startActivity(intent)
        }

        //Opcion Log in
        val tvLogin = findViewById<TextView>(R.id.TvredirLog_in)

        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etCorreo = findViewById<TextInputEditText>(R.id.etTitular)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)


        val btLog = findViewById<Button>(R.id.btLog)
        btLog.setOnClickListener {
            if(option == "paciente"){
                val patient = Patient(
                    id= 0,
                    name = etName.text.toString(),
                    lastname = "",
                    age = 22,
                    email = etCorreo.text.toString(),
                    password = etPassword.text.toString(),
                    height = 0.0,
                    weight = 0.0,
                    body_mass_index = 0.0,
                    fecha_nacimiento = "17/06/2001",
                    telefono = "953922211",
                    profileImage = "https://i.pinimg.com/736x/d3/7b/02/d37b020e87945ad7f245e48df752ed03.jpg");


                RetrofitInstance.ApiPatient.createPatient(patient).enqueue(object : retrofit2.Callback<Patient> {
                    override fun onResponse(call: retrofit2.Call<Patient>, response: retrofit2.Response<Patient>) {
                        if (response.isSuccessful) {
                            val patient = response.body()
                            Toast.makeText(this@IngresarDatosRegistro, "Usuario Creado", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@IngresarDatosRegistro, IngresarDatosLogin::class.java)
                            intent.putExtra("opcion", "paciente")
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<Patient>, t: Throwable) {
                        t.printStackTrace()
                    }
                })
            }
            else{
                val doctor = Doctor(
                    id= 0,
                    name = etName.text.toString(),
                    lastname = "",
                    specialty = "Medicina General",
                    email = etCorreo.text.toString(),
                    password = etPassword.text.toString(),
                    height = 0.0,
                    weight = 0.0,
                    bodyMassIndex = 0.0,
                    profileImage = "https://i.pinimg.com/736x/f4/c9/ef/f4c9ef33d04a22050038e9e53eeb7d85.jpg",
                    puntuation = "5",
                    costo = "150");


                RetrofitInstance.ApiDoctor.registerDoctor(doctor).enqueue(object : retrofit2.Callback<Doctor> {
                    override fun onResponse(call: retrofit2.Call<Doctor>, response: retrofit2.Response<Doctor>) {
                        if (response.isSuccessful) {
                            val doctor = response.body()
                            Toast.makeText(this@IngresarDatosRegistro, "Doctor Creado", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@IngresarDatosRegistro, IngresarDatosLogin::class.java)
                            intent.putExtra("opcion", "profesional")
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<Doctor>, t: Throwable) {
                        t.printStackTrace()
                    }
                })

            }



        }
    }
}