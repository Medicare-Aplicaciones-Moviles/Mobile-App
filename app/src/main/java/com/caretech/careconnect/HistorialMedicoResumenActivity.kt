package com.caretech.careconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.caretech.careconnect.User.Patient
import com.caretech.careconnect.models.Alergia
import com.caretech.careconnect.adapter.AlergiaHistorialAdapter

class HistorialMedicoResumenActivity : AppCompatActivity() {


    val alergias = ArrayList<Alergia>()
    var alergiasAdapter = AlergiaHistorialAdapter(alergias)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_historial_medico_resumen)

        val patient: Patient?
        patient = intent.getSerializableExtra("patient") as Patient

        val tvAlturaHistorialResumen = findViewById<android.widget.TextView>(R.id.tvAlturaHistorialResumen)
        val tvPesoHistorialResumen = findViewById<android.widget.TextView>(R.id.tvPesoHistorialResumen)
        val tvMasaCorporalHistorialResumen = findViewById<android.widget.TextView>(R.id.tvMasaCorporalHistorialResumen)
        val tvNombrePacienteResumen = findViewById<android.widget.TextView>(R.id.tvNombrePacienteResumen)
        val tvEdad = findViewById<android.widget.TextView>(R.id.tvEdad)
        val ivFotoPerfil = findViewById<android.widget.ImageView>(R.id.ivFotoPerfil)

        tvNombrePacienteResumen.text = patient?.name + " " + patient?.lastname
        tvEdad.text = patient?.fecha_nacimiento + " - " +  patient?.age.toString()
        tvAlturaHistorialResumen.text = patient?.height.toString()
        tvPesoHistorialResumen.text = patient?.weight.toString()
        tvMasaCorporalHistorialResumen.text = patient?.body_mass_index.toString()
        Glide.with(this)
            .load(patient?.profileImage)
            .into(ivFotoPerfil)


        loadAlergias()
        initView()

        val ibBackHistorialResumen = findViewById<ImageButton>(R.id.ibBackHistorialResumen)

        ibBackHistorialResumen.setOnClickListener{
            val intent = Intent(this, PatientMenuActivity::class.java)
            startActivity(intent)
        }

        val ibInicio = findViewById<ImageButton>(R.id.ibInicio)
        ibInicio.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("patient", patient)
            startActivity(intent)
        }

        val ibPerfil = findViewById<ImageButton>(R.id.ibPerfil)
        ibPerfil.setOnClickListener{
            val intent = Intent(this, PatientViewProfileActivity::class.java)
            intent.putExtra("patient", patient)
            startActivity(intent)
        }

        val btSave = findViewById<Button>(R.id.btSave)
        btSave.setOnClickListener{
            val intent = Intent(this, PatientMenuActivity::class.java)
            intent.putExtra("patient", patient)
            startActivity(intent)
        }


    }

    private fun initView(){
        val rvMedicamentosAlergias = findViewById<RecyclerView>(R.id.rvMedicamentosAlergias)

        rvMedicamentosAlergias.adapter =alergiasAdapter
        rvMedicamentosAlergias.layoutManager = LinearLayoutManager(this)
    }


    private fun loadAlergias(){
        alergias.add(Alergia("Polvo"))
        println("hola")
    }
}
