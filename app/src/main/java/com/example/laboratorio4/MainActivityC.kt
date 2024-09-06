package com.example.laboratorio4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivityC : ComponentActivity() {
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
    val settings = painterResource(R.drawable.x)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //"Settings" centrado y el ícono "X" a la izquierda
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = settings,
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(id = R.string.setting),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Settings",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }

        //Parte sin espacio entre ellos (botones)
        SettingButton(
            icon = painterResource(R.drawable.profile),
            text = "Edit Profile",
            onClick = { Toast.makeText(context, "PROFILE!", Toast.LENGTH_SHORT).show() }
        )

        SettingButton(
            icon = painterResource(R.drawable.email),
            text = "Email Addresses",
            onClick = { Toast.makeText(context, "Email Addresses", Toast.LENGTH_SHORT).show() }
        )

        SettingButton(
            icon = painterResource(R.drawable.notifications),
            text = "Notifications",
            onClick = { Toast.makeText(context, "NOTIFICATIONS!", Toast.LENGTH_SHORT).show() }
        )

        SettingButton(
            icon = painterResource(R.drawable.privacy),
            text = "Privacy",
            onClick = { Toast.makeText(context, "PRIVACY!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        //Botones con textos en diferentes formatos
        SettingButtonWithSubtitle(
            icon = painterResource(R.drawable.interrogacion),
            title = "Help & Feedback",
            subtitle = "Troubleshooting tips and guides",
            onClick = { Toast.makeText(context, "Help & Feedback", Toast.LENGTH_SHORT).show() }
        )

        SettingButtonWithSubtitle(
            icon = painterResource(R.drawable.i),
            title = "About",
            subtitle = "App information and documents",
            onClick = { Toast.makeText(context, "ABOUT!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        //Botón de Logout con espacio
        OutlinedButton(
            onClick = { Toast.makeText(context, "Logging out...", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Text(
                text = "Logout",
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun SettingButton(
    icon: Painter,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun SettingButtonWithSubtitle(
    icon: Painter,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = subtitle,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    Laboratorio4Theme {
        App("LAB#4 Mi Perfil")
    }
}
