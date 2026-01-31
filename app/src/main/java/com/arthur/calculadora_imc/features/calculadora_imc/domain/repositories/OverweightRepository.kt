package com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories

import com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight

interface OverweightRepository {
    suspend fun calcularIMC(peso: Double, altura: Double): com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight
}