package com.caretech.careconnect.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.caretech.careconnect.R
import com.caretech.careconnect.SeleccionarFechaActivity
import com.caretech.careconnect.User.Doctor
import com.caretech.careconnect.User.Patient

class DoctorAdapter(val doctors: List<Doctor>, private val patient: Patient) : Adapter<DoctorPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorPrototype {
        //Inflar la vista
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_doctors_cita, parent, false)

        return DoctorPrototype(view, patient)
    }

    override fun onBindViewHolder(holder: DoctorPrototype, position: Int) {
        holder.bind(doctors[position])
    }

    override fun getItemCount(): Int {
        return doctors.size
    }


}

class DoctorPrototype(itemView: View, private val patient: Patient) : ViewHolder(itemView) {
    val ivDoctor = itemView.findViewById<ImageView>(R.id.ivDoctores)
    val tvNombreDoctor = itemView.findViewById<TextView>(R.id.tvNombreDoctor)
    val tvEspecialidad = itemView.findViewById<TextView>(R.id.tvEspecializacionDoctor)
    val tvCalificacion = itemView.findViewById<TextView>(R.id.tvCalificacionDoctor)
    val tvPrecioPorCita = itemView.findViewById<TextView>(R.id.tvPrecioPorCita)
    val ivSacarCita = itemView.findViewById<ImageView>(R.id.ivSacarCitaButton)

    @SuppressLint("SetTextI18n")
    fun bind(doctor: Doctor){
        tvNombreDoctor.text = doctor.name + "" + doctor.lastname
        tvEspecialidad.text = doctor.specialty
        tvCalificacion.text = doctor.puntuation
        tvPrecioPorCita.text = doctor.costo
        Glide.with(itemView.context)
            .load(doctor.profileImage)
            .into(ivDoctor)


        ivSacarCita.setOnClickListener{
            val context = itemView.context
            val intent = Intent(context, SeleccionarFechaActivity::class.java).apply {
                putExtra("doctor", doctor)
                putExtra("patient", patient)
            }
            context.startActivity(intent)
        }
    }


}
