package com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase


class OverweightViewModelFactory(
    private val useCase: GetOverweightUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverweightViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OverweightViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}