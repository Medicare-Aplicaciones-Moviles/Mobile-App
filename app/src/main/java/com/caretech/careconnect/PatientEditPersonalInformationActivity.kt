package com.caretech.careconnect

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.caretech.careconnect.Remote.RetrofitInstance
import com.caretech.careconnect.User.Patient
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response
import java.io.Serializable

class PatientEditPersonalInformationActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        val patient = intent.getSerializableExtra("patient") as? Patient

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient_edit_personal_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombrePaciente = findViewById<TextView>(R.id.tvNombre)
        nombrePaciente.text = patient?.name + " " + patient?.lastname

        val edadPaciente = findViewById<TextView>(R.id.tvFechaNacimiento)
        edadPaciente.text = patient?.age.toString()

        val height = findViewById<TextInputEditText>(R.id.tietAltura)
        height.setText(patient?.height.toString())

        val bodyMass = findViewById<TextInputEditText>(R.id.tietMasaCorporal)
        bodyMass.setText(patient?.body_mass_index.toString())

        val weight = findViewById<TextInputEditText>(R.id.tietPeso)
        weight.setText(patient?.weight.toString())

        //BotonBack
        val btnBack = findViewById<ImageButton>(R.id.ibBackWhite)

        btnBack.setOnClickListener {
            val intent = Intent(this, PatientViewProfileActivity::class.java)
            startActivity(intent)
        }

        val btnActualizar = findViewById<Button>(R.id.btActualizar)
        btnActualizar.setOnClickListener{
            val intent = Intent(this, PatientViewProfileActivity::class.java)
            if(height.text.toString().isNotEmpty() && bodyMass.text.toString().isNotEmpty() && weight.text.toString().isNotEmpty()){
                val patientActualizado = patient?.let { it1 ->
                    Patient(
                        id = it1.id,
                        name = it1.name,
                        lastname = it1.lastname,
                        age = it1.age,
                        email = it1.email,
                        password = it1.password,
                        height = height.text.toString().toDouble(),
                        weight = weight.text.toString().toDouble(),
                        body_mass_index = bodyMass.text.toString().toDouble()
                    )
                }

                RetrofitInstance.ApiPatient.updatePatient(patientActualizado!!, patientActualizado.id).enqueue(object : retrofit2.Callback<Patient> {
                    override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                        if(response.isSuccessful){
                            val updatedPatient = response.body()
                            Toast.makeText(this@PatientEditPersonalInformationActivity, "Datos actualizados", Toast.LENGTH_SHORT).show()

                            val resultIntent = Intent()
                            resultIntent.putExtra("patient", updatedPatient as Serializable)
                            setResult(RESULT_OK, resultIntent)
                            finish()

                        }
                        else{
                            Toast.makeText(this@PatientEditPersonalInformationActivity, "Error al actualizar los datos", Toast.LENGTH_SHORT).show()

                        }
                    }

                    override fun onFailure(call: Call<Patient>, t: Throwable) {
                        Toast.makeText(this@PatientEditPersonalInformationActivity, "Error al actualizar los datos", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            startActivity(intent)
        }
    }
}