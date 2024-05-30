package com.caretech.careconnect

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.caretech.careconnect.User.Patient



class PatientViewProfileActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE_UPDATE_PATIENT  = 1
    }

    private var patient: Patient? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        patient = intent.getSerializableExtra("patient") as? Patient
        val numbder = 13

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_view_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombrePaciente = findViewById<TextView>(R.id.tvNombre)
        nombrePaciente.text = patient?.name + " " + patient?.lastname

        val edadPaciente = findViewById<TextView>(R.id.tvFechaNacimiento)
        edadPaciente.text = patient?.age.toString()




        //BtnLeerInfoPersonal
        val btnLeerInfoPersonal = findViewById<Button>(R.id.btLeerInfoPersonal)

        btnLeerInfoPersonal.setOnClickListener {
            val intent = Intent(this, PatientEditPersonalInformationActivity::class.java)
            if(patient != null) {
                intent.putExtra("patient", patient)
            }
            startActivityForResult(intent, REQUEST_CODE_UPDATE_PATIENT)
        }

        //BotonBack
        val btnBack = findViewById<ImageButton>(R.id.ibBackWhite)

        btnBack.setOnClickListener {
            val intent = Intent(this, PatientMenuActivity::class.java)
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_UPDATE_PATIENT && resultCode == RESULT_OK) {
            val patientUpdated = data?.getSerializableExtra("patient") as? Patient

            if(patientUpdated != null) {
                patient = patientUpdated
            }

            val nombrePaciente = findViewById<TextView>(R.id.tvNombre)
            nombrePaciente.text = patient?.name + " " + patient?.lastname

            val edadPaciente = findViewById<TextView>(R.id.tvFechaNacimiento)
            edadPaciente.text = patient?.age.toString()

        }
    }
}