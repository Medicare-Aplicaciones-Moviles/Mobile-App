package com.caretech.careconnect

import retrofit2.Call
import retrofit2.http.GET

interface PagoService {
    @GET("ingresos_pagos") // Reemplazar el end point Willy
    fun getIngresosPagos(): Call<List<ListElementIngresosPagos>>
}
