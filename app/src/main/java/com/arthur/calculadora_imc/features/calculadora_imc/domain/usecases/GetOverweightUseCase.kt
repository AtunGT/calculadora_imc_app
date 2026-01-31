package com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases

import com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight
import com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories.OverweightRepository

class GetOverweightUseCase(private val repository: com.arthur.calculadora_imc.features.calculadora_imc.domain.repositories.OverweightRepository) {
    suspend operator fun invoke(peso: Double, altura: Double): com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight {
        return repository.calcularIMC(peso, altura)
    }
}