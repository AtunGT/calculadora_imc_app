package com.arthur.calculadora_imc.features.calculadora_imc.presentation.screens

import com.arthur.calculadora_imc.R

data class OverweightUIState(
    val peso: String = "",
    val altura: String = "",
    val imc: Double = 0.0,
    val estado: String = "",
    val imagenRes: Int = R.drawable.gato
)