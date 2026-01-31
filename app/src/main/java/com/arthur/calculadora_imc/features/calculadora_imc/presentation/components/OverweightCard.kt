package com.arthur.calculadora_imc.features.calculadora_imc.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OverweightCard(
    peso: String,
    onPesoChange: (String) -> Unit,
    altura: String,
    onAlturaChange: (String) -> Unit,
    onCalcular: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = peso,
                onValueChange = onPesoChange,
                label = { Text("Peso (kg)", fontSize = 22.sp, color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 22.sp, color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = altura,
                onValueChange = onAlturaChange,
                label = { Text("Altura (m) ej: 1.75", fontSize = 22.sp, color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 22.sp, color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = onCalcular,
                modifier = Modifier.fillMaxWidth().height(65.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF40E0D0)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Calcular", color = Color.Black, fontSize = 22.sp)
            }
        }
    }
}