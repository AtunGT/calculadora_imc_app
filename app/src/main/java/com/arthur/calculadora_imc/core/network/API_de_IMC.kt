package com.arthur.calculadora_imc.core.network

import com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.model.OverweightResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface Api_De_Imc {

    @GET("api/bmi/{weight}/{height}")
    suspend fun getImc(
        @Path("weight") peso: Double,
        @Path("height") altura: Double
    ): com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.model.OverweightResponse
}