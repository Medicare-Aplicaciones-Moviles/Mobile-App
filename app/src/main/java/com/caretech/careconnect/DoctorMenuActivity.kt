package com.caretech.careconnect

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DoctorMenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //BtnPerfil
        val btnPerfil = findViewById<ImageButton>(R.id.ibPerfil)

        btnPerfil.setOnClickListener {
            val intent = Intent(this, PatientViewProfileActivity::class.java)
            startActivity(intent)
        }
        //BtnAgenda
        //FALTA PANTALLA DE AGENDA
        val btAgenda = findViewById<Button>(R.id.btAgenda)

        btAgenda.setOnClickListener{
            val intent = Intent(this, HistorialMedicoActivity::class.java)
            startActivity(intent)
        }
        //BtnPatient
        val btPatient = findViewById<Button>(R.id.btPatient)

        btPatient.setOnClickListener{
            val intent = Intent(this, CitaMenuActivity::class.java)
            startActivity(intent)
        }
        //BtnIngresos_Costos
        //FALTA PANTALLA DE INGRESOS Y COSTOS
        val btIngresos_Pagos = findViewById<Button>(R.id.btIngresos_Pagos)

        btIngresos_Pagos.setOnClickListener{
            val intent = Intent(this, CitaMenuActivity::class.java)
            startActivity(intent)
        }
    }
}