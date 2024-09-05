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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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


class MainActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        name = "Lab#4 Mi Perfil",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(name: String, modifier: Modifier = Modifier) {
    //Images
    val image1 = painterResource(R.drawable.library)
    val settings = painterResource(R.drawable.settings)

    val context = LocalContext.current.applicationContext //Action button

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        //Mi Perfil
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "My Profile",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.paddingFromBaseline(top = 50.dp)
            )
        }
    }

    Column (
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxSize()
    ) {
        //Settings
        Image(
            painter = settings,
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(id = R.string.setting),
            modifier = Modifier.size(40.dp)
        )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            //Fondo usuario
            Image(
                painter = image1,
                contentScale = ContentScale.FillWidth,
                contentDescription = stringResource(id = R.string.library),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            //Foto usuario
            Image(
                painter = painterResource(R.drawable.user),
                contentDescription = stringResource(id = R.string.user),
                modifier = Modifier
                    .size(115.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = (-420).dp)
            )
            //Nombre Perfil
            Text(
                text = "FRANCISCO ROGELIO ANZUETO MARROQUIN",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.paddingFromBaseline(top = 330.dp)
            )

            //BOTONES
                //My Campus
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY CAMPUS!", Toast.LENGTH_SHORT).show() }, //Aparece texto al precionar botón
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp), //Botón semi cuadrado
                modifier = Modifier.width(470.dp).paddingFromBaseline(top = 400.dp), //Propiedades botón
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding //Botón con ícono en él
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ){
                    //Ícono
                    Icon(
                        painter = painterResource(R.drawable.my_campus),
                        contentDescription = stringResource(id = R.string.my_campus),
                        tint = Color(0xFF006400),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp)) //espacio entre ícono y texto
                    //Texto
                    Text(
                        text = buildAnnotatedString { //Para agregar texto abajo
                            append("My Campus\n")
                            withStyle(style = SpanStyle(fontSize = 10.sp)) { // Modifica el tamaño de "Campus Central"
                                append("Central Campus") //Agregar texto
                            }
                        },
                        color = Color.Black,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 0.7.em
                    )
                }

            }

            //My Friends
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY FRIENDS!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 456.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        painter = painterResource(R.drawable.my_friends),
                        contentDescription = stringResource(id = R.string.my_friends),
                        tint = Color(0xFF3761CE),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = "My Friends",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }

            }

            //My Calendar
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY CALENDAR!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 502.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        painter = painterResource(R.drawable.my_calendar),
                        contentDescription = stringResource(id = R.string.my_calendar),
                        tint = Color(0xFF58cb8e),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(text = "My Calendar",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }

            //My Courses
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY COURSES!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 548.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.my_courses),
                        contentDescription = stringResource(id = R.string.my_courses),
                        tint = Color(0xFFdd6a46),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "My Courses",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }

            //My Grades
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY GRADES!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 594.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.my_grades),
                        contentDescription = stringResource(id = R.string.my_grades),
                        tint = Color(0xFF545fe5),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "My Grades",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }

            //My Groups
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY GROUPS!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 640.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.my_groups),
                        contentDescription = stringResource(id = R.string.my_groups),
                        tint = Color(0xFF5860e8),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "My Groups",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }

            //My Upcoming Events
            OutlinedButton(
                onClick = { Toast.makeText(context, "MY UPCOMING EVENTS!", Toast.LENGTH_SHORT).show() },
                shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp, bottomEnd = 5.dp, bottomStart = 5.dp),
                modifier = Modifier.width(450.dp).paddingFromBaseline(top = 686.dp),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.my_events),
                        contentDescription = stringResource(id = R.string.my_events),
                        tint = Color(0xFF50becb),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "My Upcoming Events",
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }

    }
}


@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("Click!")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    Laboratorio4Theme{
        App("LAB#4 Mi Perfil")
    }
}