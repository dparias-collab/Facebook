package com.example.diego.parias.facebook

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaswdScreen(
    onClickBack: () -> Unit = {},
    onBuscar: (String) -> Unit = {}
) {
    var dato by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    fun validarYBuscar() {
        val texto = dato.trim()
        error = when {
            texto.isEmpty() -> "Escribe tu correo o número de celular"
            !Patterns.EMAIL_ADDRESS.matcher(texto).matches() &&
                    !(Patterns.PHONE.matcher(texto).matches() && texto.length >= 7) ->
                "Ingresa un correo o celular válido"
            else -> null
        }
        if (error == null) onBuscar(texto)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recuperar contraseña", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Text(
                            text = "←",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Encuentra tu cuenta",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Introduce tu correo electrónico o número de celular para buscar tu cuenta.",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = dato,
                onValueChange = { dato = it; error = null },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Correo o celular") },
                singleLine = true,
                isError = error != null,
                supportingText = { error?.let { Text(it) } },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = { validarYBuscar() })
            )
            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { validarYBuscar() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Buscar", fontSize = 17.sp)
            }
            Spacer(Modifier.height(8.dp))

            OutlinedButton(
                onClick = onClickBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Cancelar", fontSize = 17.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaswdScreenPreview() {
    MaterialTheme { PaswdScreen() }
}