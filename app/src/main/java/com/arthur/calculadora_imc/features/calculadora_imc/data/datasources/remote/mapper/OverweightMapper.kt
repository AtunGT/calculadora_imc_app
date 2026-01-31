package com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.mapper



import com.arthur.calculadora_imc.R
import com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.model.OverweightResponse
import com.arthur.calculadora_imc.features.calculadora_imc.domain.entities.Overweight


fun OverweightResponse.toDomain(): Overweight {
    val imagen = when (this.category) {
        "Underweight" -> R.drawable.gato_4
        "Normal weight" -> R.drawable.gato_1
        "Overweight" -> R.drawable.gato_2
        else -> R.drawable.gato_3
    }
    return Overweight(
        imc = this.bmi,
        estado = "Estado: ${this.category}",
        imagenRes = imagen
    )
}