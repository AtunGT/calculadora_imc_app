package com.arthur.calculadora_imc.core.di

import android.content.Context
import com.arthur.calculadora_imc.core.network.Api_De_Imc
import com.arthur.calculadora_imc.features.calculadora_imc.data.repositories.OverweightRepositoryImpl
import com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories.OverweightRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://bmicalculatorapi.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api_De_Imc: Api_De_Imc by lazy {
        retrofit.create(Api_De_Imc::class.java)
    }

    val overweightRepository: com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories.OverweightRepository by lazy {
        _root_ide_package_.com.arthur.calculadora_imc.features.calculadora_imc.data.repositories.OverweightRepositoryImpl(
            api_De_Imc
        )
    }
}