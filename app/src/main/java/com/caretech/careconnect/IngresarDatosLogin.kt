package com.caretech.careconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IngresarDatosLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingresar_datos_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton back
        val btnBack = findViewById<ImageButton>(R.id.ibBack)

        btnBack.setOnClickListener {
            val intent = Intent(this, RolCuentaActivity::class.java)
            startActivity(intent)
        }

        //Opcion tvNoAccount
        val tvNoAccount = findViewById<TextView>(R.id.tvNoAccount)

        tvNoAccount.setOnClickListener {
            val intent = Intent(this, IngresarDatosRegistro::class.java)
            startActivity(intent)
        }

        //Opcion Login
        val btnLogin = findViewById<Button>(R.id.btLog)

        btnLogin.setOnClickListener {
            val intent = Intent(this, PatientMenuActivity::class.java)
            startActivity(intent)
        }

    }
}
