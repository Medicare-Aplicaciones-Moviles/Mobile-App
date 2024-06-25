package com.caretech.careconnect

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TerminosCondiciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terminos_condiciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val cbAceptar = findViewById<CheckBox>(R.id.cbAceptar)
        cbAceptar.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                val intent = Intent(this@TerminosCondiciones, RolInteractivityRegister::class.java)
                startActivity(intent)

            } else {
                // The checkbox is unchecked
            }
        }

    }
}