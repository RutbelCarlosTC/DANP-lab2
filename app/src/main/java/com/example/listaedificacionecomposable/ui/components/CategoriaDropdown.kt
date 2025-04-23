package com.example.listaedificacionecomposable.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoriaDropdown(opciones: List<String>, seleccionada: String, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Categoría", fontWeight = FontWeight.Bold)
        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(seleccionada)
                Icon(Icons.Default.ArrowDropDown, contentDescription = null)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                opciones.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            onSelected(opcion)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

// Probando la funcion composabel
@Preview(showBackground = true)
@Composable
fun CategoriaDropdownPreview() {

    MaterialTheme {
        // Lista de ejemplo para las opciones
        val categorias = listOf("Frutas", "Verduras", "Lácteos", "Carnes", "Bebidas")

        // Estado recordado para la selección actual en la preview
        var categoriaSeleccionada by remember { mutableStateOf(categorias[0]) }

        CategoriaDropdown(
            opciones = categorias,
            seleccionada = categoriaSeleccionada,
            onSelected = { nuevaCategoria ->
                categoriaSeleccionada = nuevaCategoria
            }
        )
    }
}