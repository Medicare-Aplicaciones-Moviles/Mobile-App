package com.caretech.careconnect
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caretech.careconnect.PagoRealizadoActivity
import com.caretech.careconnect.R
import com.caretech.careconnect.Remote.RetrofitInstance
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient
import com.caretech.careconnect.models.Appointment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PagoCitaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_cita)

        // Obtener datos del intent
        val doctor = intent.getSerializableExtra("doctor") as Doctor
        val patient = intent.getSerializableExtra("patient") as Patient
        val selectedDate = intent.getStringExtra("selectedDate") as String
        val selectedTime = intent.getStringExtra("selectedTime")

        // Referencias a elementos de la interfaz de usuario (si es necesario)

        val btnConfirmar = findViewById<Button>(R.id.btConfirmar)


        btnConfirmar.setOnClickListener {

            // Crear objeto Appointment con los datos necesarios
            val appointment = Appointment(
                id = null,
                date =  "2024-06-20T18:57:44.708+00:00",
                description = "Cita con el docotr " + doctor.name + " el día " + selectedDate + " a las " + selectedTime,
                patient_id = patient.id,
                doctor_id = doctor.id
            )

            val ress = 123

           RetrofitInstance.ApiAppointment.createAppointment(appointment).enqueue(object : Callback<Appointment> {
               override fun onResponse(call: Call<Appointment>, response: Response<Appointment>) {
                   if (response.isSuccessful) {
                       Log.d("Success", "Cita creada correctamente")
                       val intent = Intent(this@PagoCitaActivity, PagoRealizadoActivity::class.java)
                       startActivity(intent)
                   } else {
                           Log.e("Error", "Error al crear la cita: ${response.code()}")
                   }
               }

               override fun onFailure(call: Call<Appointment>, t: Throwable) {
                   Log.e("Error", "Error al crear la cita: ${t.message}")
                   // Manejar el error de conexión aquí si es necesario
               }
           })


        }
    }
}
