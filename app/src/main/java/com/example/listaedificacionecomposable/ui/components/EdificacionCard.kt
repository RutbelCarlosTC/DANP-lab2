package com.example.listaedificacionecomposable.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp import com.example.listaedificacionecomposable.model.Edificacion
import com.example.listaedificacionecomposable.R


@Composable
fun EdificationCard(edification: Edificacion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(edification.imagenRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(edification.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(edification.categoria, fontSize = 14.sp)
                Text(edification.descripcion, fontStyle = FontStyle.Italic, fontSize = 12.sp)
            }
        }
    }
}
@Preview
@Composable
fun PreviewEdificationCard() {
    EdificationCard(Edificacion("Monasterio de Santa Catalina", "Religioso", "Convento histórico en Arequipa", R.drawable.santa_catalina))
}