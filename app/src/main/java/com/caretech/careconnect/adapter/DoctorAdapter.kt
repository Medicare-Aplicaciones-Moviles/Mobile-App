package com.caretech.careconnect.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.caretech.careconnect.R
import com.caretech.careconnect.models.Doctor

class DoctorAdapter(val doctors: List<Doctor>) : Adapter<DoctorPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorPrototype {
        //Inflar la vista
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_doctores_cita, parent, false)

        return DoctorPrototype(view)
    }

    override fun onBindViewHolder(holder: DoctorPrototype, position: Int) {
        holder.bind(doctors[position])
    }

    override fun getItemCount(): Int {
        return doctors.size
    }


}

class DoctorPrototype(itemView: View) : ViewHolder(itemView) {
    val ivDoctor = itemView.findViewById<ImageView>(R.id.ivDoctores)
    val tvNombreDoctor = itemView.findViewById<TextView>(R.id.tvNombreDoctor)
    val tvEspecialidad = itemView.findViewById<TextView>(R.id.tvEspecializacionDoctor)
    val tvCalificacion = itemView.findViewById<TextView>(R.id.tvCalificacionDoctor)
    val tvPrecioPorCita = itemView.findViewById<TextView>(R.id.tvPrecioPorCita)
    //val ibSacarCita = itemView.findViewById<ImageButton>(R.id.ivSacarCitaButton)

    @SuppressLint("SetTextI18n")
    fun bind(doctor: Doctor){
        tvNombreDoctor.text = doctor.name + "" + doctor.lastName
        tvEspecialidad.text = doctor.speciality
        tvCalificacion.text = doctor.calification.toString()
        tvPrecioPorCita.text = doctor.appointmentPrice.toString()
        //Mostrar la imagen del doctor
        Glide.with(itemView)
            .load(doctor.photo)
            .into(ivDoctor)
    }


}
