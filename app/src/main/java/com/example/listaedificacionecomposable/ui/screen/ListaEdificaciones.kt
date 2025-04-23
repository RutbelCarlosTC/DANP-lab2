package com.example.listaedificacionecomposable.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.listaedificacionecomposable.R
import com.example.listaedificacionecomposable.model.Edificacion
import com.example.listaedificacionecomposable.ui.components.CategoriaDropdown
import com.example.listaedificacionecomposable.ui.components.EdificacionCard

@Composable
fun ListaEdificaciones() {
    val edificaciones = listOf(
        Edificacion("Monasterio de Santa Catalina", "Religioso", "Convento histórico en Arequipa", R.drawable.santa_catalina),
        Edificacion("Catedral de Arequipa", "Religioso", "Catedral en la Plaza de Armas", R.drawable.catedral_arequipa),
        Edificacion("Casa del Moral", "Residencial", "Antigua casa colonial", R.drawable.casa_del_moral)
    )

    var searchQuery by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf("Todas") }
    val categorias = listOf("Todas", "Religioso", "Residencial")

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar edificaciones") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        CategoriaDropdown(
            opciones = categorias,
            seleccionada = categoriaSeleccionada
        ) {
            categoriaSeleccionada = it
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(edificaciones.filter {
                (categoriaSeleccionada == "Todas" || it.categoria == categoriaSeleccionada) &&
                it.nombre.contains(searchQuery, ignoreCase = true)
            }) { edificacion ->
                EdificacionCard(edificacion)
            }
        }
    }
}