package com.example.laboratorio4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.em
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
    val context = LocalContext.current.applicationContext

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Settings",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = settings,
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(id = R.string.setting),
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(Modifier.height(32.dp))

        SettingButton(
            icon = painterResource(R.drawable.profile),
            text = "Profile\nCentral Campus",
            onClick = { Toast.makeText(context, "PROFILE!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        SettingButton(
            icon = painterResource(R.drawable.email),
            text = "Email Addresses",
            onClick = { Toast.makeText(context, "Email Addresses", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        SettingButton(
            icon = painterResource(R.drawable.notifications),
            text = "Notifications",
            onClick = { Toast.makeText(context, "NOTIFICATIONS!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        SettingButton(
            icon = painterResource(R.drawable.privacy),
            text = "Privacy",
            onClick = { Toast.makeText(context, "PRIVACY!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        SettingButton(
            icon = painterResource(R.drawable.interrogacion),
            text = "Help & Feedback\nTroubleshooting tips and guides",
            onClick = { Toast.makeText(context, "Help & Feedback", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        SettingButton(
            icon = painterResource(R.drawable.i),
            text = "About\nApp information and documents",
            onClick = { Toast.makeText(context, "ABOUT!", Toast.LENGTH_SHORT).show() }
        )

        Spacer(Modifier.height(16.dp))

        OutlinedButton(
            onClick = { Toast.makeText(context, "Loggin out...", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {Text(
            text = "Logout",
            color = Color.Red,
            fontSize = 20.sp,
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
            verticalAlignment =Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color(0xFF006400),
                modifier = Modifier.size(32.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = buildAnnotatedString {
                    val lines = text.split("\n")
                    append(lines[0] + "\n")
                    if (lines.size > 1) {
                        withStyle(style = SpanStyle(fontSize = 10.sp)) {
                            append(lines[1])
                        }
                    }
                },
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                lineHeight = 0.7.em
            )
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