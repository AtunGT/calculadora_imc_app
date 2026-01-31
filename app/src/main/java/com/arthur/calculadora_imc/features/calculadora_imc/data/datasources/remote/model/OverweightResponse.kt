package com.arthur.calculadora_imc.features.calculadora_imc.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class OverweightResponse(
    @SerializedName("bmi") val bmi: Double,
    @SerializedName("Category") val category: String,
    @SerializedName("weight") val weight: Double,
    @SerializedName("height") val height: Double
)