package com.arthur.calculadora_imc.features.calculadora_imc.di

import com.arthur.calculadora_imc.core.di.AppContainer
import com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory

class OverweightModule(
    private val appContainer: AppContainer
) {
    fun provideGetOverweightUseCase(): com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase {
        return _root_ide_package_.com.arthur.calculadora_imc.features.calculadora_imc.domain.usecases.GetOverweightUseCase(
            appContainer.overweightRepository
        )
    }

    fun provideOverweightViewModelFactory(): com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory {
        return _root_ide_package_.com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory(
            provideGetOverweightUseCase()
        )
    }
}