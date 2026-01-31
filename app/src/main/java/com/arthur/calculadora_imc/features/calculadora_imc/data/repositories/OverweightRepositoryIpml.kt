package com.arthur.calculadora_imc.features.calculadora_imc.data.repositories

import com.arthur.calculadora_imc.core.network.Api_De_Imc
import com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight
import com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories.OverweightRepository
import com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.mapper.toDomain

class OverweightRepositoryImpl(
    private val api: Api_De_Imc
) : OverweightRepository {

    override suspend fun calcularIMC(peso: Double, altura: Double): Overweight {
        val response = api.getImc(peso, altura)
        return response.toDomain()
    }
}