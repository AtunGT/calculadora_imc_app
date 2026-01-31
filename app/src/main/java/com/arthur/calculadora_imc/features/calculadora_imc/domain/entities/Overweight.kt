package com.arthur.calculadora_imc.features.calculadora_imc.domain.entities

data class Overweight(
    val imc: Double,
    val estado: String,
    val imagenRes: Int
)