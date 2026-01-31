package com.arthur.calculadora_imc.features.calculadora_imc.di

import com.arthur.calculadora_imc.core.di.AppContainer
import com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory

class OverweightModule(
    private val appContainer: AppContainer
) {
    fun provideGetOverweightUseCase(): GetOverweightUseCase {
        return GetOverweightUseCase(
            appContainer.overweightRepository
        )
    }

    fun provideOverweightViewModelFactory(): OverweightViewModelFactory {
        return OverweightViewModelFactory(
            provideGetOverweightUseCase()
        )
    }
}