package com.arthur.calculadora_imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arthur.calculadora_imc.core.di.AppContainer
import com.arthur.calculadora_imc.core.ui.theme.AppTheme
import com.arthur.calculadora_imc.features.calculadora_imc.di.OverweightModule
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.screens.OverweightScreen


class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        val overweightModule = OverweightModule(appContainer)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                OverweightScreen(overweightModule.provideOverweightViewModelFactory())
            }
        }
    }
}