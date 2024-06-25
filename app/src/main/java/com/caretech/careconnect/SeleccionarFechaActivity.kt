package com.caretech.careconnect
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient

class SeleccionarFechaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seleccionar_fecha)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val doctor = intent.getSerializableExtra("doctor") as Doctor
        val patient = intent.getSerializableExtra("patient") as Patient
        var selectedDate = ""
        var selectedTime = ""

        val btnSiguiente = findViewById<Button>(R.id.btSiguiente)
        val cvFecha = findViewById<CalendarView>(R.id.cvFecha)
        val tpHorario = findViewById<TimePicker>(R.id.tpHorario)

        //capturar la fecha seleccionada
        cvFecha.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        }

        //capturar la hora seleccionada
        tpHorario.setOnTimeChangedListener { view, hourOfDay, minute ->
            selectedTime = String.format("%02d:%02d", hourOfDay, minute)
        }

        btnSiguiente.setOnClickListener {
            val intent = Intent(this, PagoCitaActivity::class.java).apply {
                putExtra("doctor", doctor)
                putExtra("patient", patient)
                putExtra("selectedDate", selectedDate)
                putExtra("selectedTime", selectedTime)

            }

            startActivity(intent)
        }

    }
}