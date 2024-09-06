package com.example.laboratorio4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivityD : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppD(
                        name = "Lab#4 Mi Perfil",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppD(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext //Action button

    Box(modifier = Modifier.fillMaxSize()) {
        // Botón de Cerrar
        IconButton(
            onClick = { Toast.makeText(context, "PESTAÑA CERRADA!", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Icon(
                Icons.Rounded.Close,
                contentDescription = stringResource(id = R.string.close),
                tint = Color(0xFF047d50)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Título
                Text(
                    text = "Emergency Contact",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.paddingFromBaseline(top = 50.dp)
                )
            }

            //Línea que divide partes
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            //Emergencias
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Imágen emergencia
                Image(
                    painter = painterResource(R.drawable.emergency),
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(id = R.string.emergency),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(8.dp))

                //Título y texto
                Text(
                    text = buildAnnotatedString { //Para agregar texto abajo
                        append("Emergencias\n")
                        withStyle(style = SpanStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)) { // Modifica el tamaño de "Campus Central"
                            append("Si se presenta un accidente o percance\n" +
                                    "porfavor marcar el número de mergencia y\n" +
                                    "rápidamente te apoyamos")
                        }
                    },
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 0.8.em,
                    fontWeight = FontWeight.Bold,
                )
            }

            //Botón para llamar
            Button(
                onClick = { Toast.makeText(context, "LLAMANDO EMERGENCIAS...", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF047d50)
                ),
                modifier = Modifier
                    .width(350.dp)
                    .paddingFromBaseline(top = 50.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    //Ícono teléfono
                    Icon(
                        painter = painterResource(R.drawable.phone),
                        contentDescription = stringResource(id = R.string.phone),
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    //Número de teléfono
                    Text(text = "Call 5374-0192",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }


            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            //Clínica UVG
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Imágen clínica
                Image(
                    painter = painterResource(R.drawable.clinica),
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(id = R.string.clinica),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = buildAnnotatedString {
                        append("Clínica UVG\n")
                        withStyle(style = SpanStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)) { // Modifica el tamaño de "Campus Central"
                            append("La Clínica UVG presta los siguientes\n" +
                                    "servicios:\n\n" +
                                    "• Atención a Emergencias\n"+
                                    "• Atención primaria a Enfermedades \nComunes"+
                                    "• Plan Educacional sobre Enfermedades\n"+
                                    "\nHorario de Atención: 7:00 a.m. a 8:30 p.m.\nCampus Central Edificio F 119-120 ")
                        }
                    },
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 0.8.em,
                    fontWeight = FontWeight.Bold,
                )

            }
            Button(
                onClick = { Toast.makeText(context, "LLAMANDO CLÍNICA...", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF047d50)
                ),
                modifier = Modifier
                    .width(350.dp)
                    .paddingFromBaseline(top = 50.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        painter = painterResource(R.drawable.phone),
                        contentDescription = stringResource(id = R.string.phone),
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = "Call 2507-1500 ex 21312",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppDPreview() {
    Laboratorio4Theme{
        AppD("LAB#4 Mi Perfil")
    }
}