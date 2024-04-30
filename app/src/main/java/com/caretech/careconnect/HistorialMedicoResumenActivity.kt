package com.caretech.careconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caretech.careconnect.Historial.Alergia

class HistorialMedicoResumenActivity : AppCompatActivity() {


    val alergias = ArrayList<Alergia>()
    var alergiasAdapter = AlergiaHistorialAdapter(alergias)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_historial_medico_resumen)


        loadAlergias()
        initView()

        val ibBackHistorialResumen = findViewById<ImageButton>(R.id.ibBackHistorialResumen)

        ibBackHistorialResumen.setOnClickListener{
            val intent = Intent(this, PatientMenuActivity::class.java)
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