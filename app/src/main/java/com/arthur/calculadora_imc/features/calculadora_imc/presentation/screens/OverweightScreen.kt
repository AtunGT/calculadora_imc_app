package com.arthur.calculadora_imc.features.calculadora_imc.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.components.OverweightCard
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModel
import com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory

@Composable
fun OverweightScreen(
    factory: com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModelFactory
) {

    val vm: com.arthur.calculadora_imc.features.calculadora_imc.presentation.viewmodels.OverweightViewModel = viewModel(
        factory = factory
    )

    val state by vm.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de índice de masa corporal",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        _root_ide_package_.com.arthur.calculadora_imc.features.calculadora_imc.presentation.components.OverweightCard(
            peso = state.peso,
            onPesoChange = { vm.onPesoChange(it) },
            altura = state.altura,
            onAlturaChange = { vm.onAlturaChange(it) },
            onCalcular = { vm.calcular() }
        )

        Spacer(modifier = Modifier.height(25.dp))

        if (state.imc > 0) {
            Text(
                text = "Tu IMC es: ${"%.3f".format(state.imc)}",
                color = Color.Black,
                fontSize = 22.sp
            )
            Text(
                text = state.estado,
                color = Color.Black,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Card(
            modifier = Modifier.size(280.dp),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                painter = painterResource(id = state.imagenRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}