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

class PatientMenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_menu)
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

        //BtnHistorialMedico
        val btHMedico = findViewById<Button>(R.id.btHMedico)
        btHMedico.setOnClickListener{
            val intent = Intent(this, HistorialMedicoActivity::class.java)
            startActivity(intent)
        }

        //BtnSacarCita
        val btSacarCita = findViewById<Button>(R.id.btSacarCita)
        btSacarCita.setOnClickListener{
            val intent = Intent(this, CitaMenuActivity::class.java)
            startActivity(intent)
        }
    }
}