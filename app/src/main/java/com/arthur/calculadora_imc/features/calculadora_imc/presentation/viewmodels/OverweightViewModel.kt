package com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.screens.OverweightUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OverweightViewModel(private val useCase: GetOverweightUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(OverweightUIState())
    val uiState = _uiState.asStateFlow()

    fun onPesoChange(valor: String) {
        _uiState.update { it.copy(peso = valor) }
    }

    fun onAlturaChange(valor: String) {
        _uiState.update { it.copy(altura = valor) }
    }

    fun calcular() {
        val p = _uiState.value.peso.toDoubleOrNull()
        val a = _uiState.value.altura.toDoubleOrNull()

        if (p != null && a != null && a > 0) {
            viewModelScope.launch {
                try {
                    val resultado = useCase(p, a)
                    _uiState.update {
                        it.copy(
                            imc = resultado.imc,
                            estado = resultado.estado,
                            imagenRes = resultado.imagenRes
                        )
                    }
                } catch (e: Exception) {
                }
            }
        }
    }
}