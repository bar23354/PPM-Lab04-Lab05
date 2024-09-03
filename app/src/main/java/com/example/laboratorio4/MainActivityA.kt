package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivityA: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                CampusInfoScreen()
            }
        }
    }
}

@Composable
fun CampusInfoScreen() {
    //comentarios para futuros proyectos:usa Column para poner el contenido verticalmente y hacer la pantalla "scrolleable"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp) //cfp: dp da espacio alrededor del contenido
    ) {
        //Importante: titulo de la pantalla
        Text(
            text = "Campus Central",
            style = MaterialTheme.typography.headlineMedium, //cfp: headline encontrado y seleccionado porque da un estilo de título
            modifier = Modifier.padding(bottom = 8.dp)
        )

        //Imagen 1 hasta arriba de la pantalla
        Image(
            painter = painterResource(id = R.drawable.biblioimagen),
            contentDescription = "Imagen del campus",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f) //cfp:ajusta la altura en función de la anchura para mantener la relación de aspecto
                .clip(RoundedCornerShape(8.dp)) //cfp:asi como dice el nombre, redondea las esquinas de la imagen
        )

        Text(
            text = "DESTACADOS",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        //Fila - elementos destacados
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HighlightCard(
                imageRes = R.drawable.servicenow,
                title = "Service Now"
            )
            HighlightCard(
                imageRes = R.drawable.actualidaduvg,
                title = "Actualidad UVG"
            )
        }

        Text(
            text = "SERVICIOS Y RECURSOS",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        //Fila - servicios y recursos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HighlightCard(
                imageRes = R.drawable.studentservices,
                title = "Directorio de Servicios Estudiantiles"
            )
            HighlightCard(
                imageRes = R.drawable.biblioimagen,
                title = "Portal Web Bibliotecas UVG"
            )
        }
    }
}

@Composable
fun HighlightCard(imageRes: Int, title: String) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .clickable { }
    ) {
        //cfp:elemento destacado (imagen), con ajuste dinámico en función de la anchura
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f) //cfp:R aspecto 1:1 para un cuadrado
                .clip(RoundedCornerShape(8.dp))
        )
        //titulo del elemento destacado
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Laboratorio4Theme {
        CampusInfoScreen()
    }
}
