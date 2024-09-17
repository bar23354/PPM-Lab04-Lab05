package com.example.laboratorio4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

@Composable
fun Settings(name: String, navController: NavHostController, modifier: Modifier = Modifier) {
    val settings = painterResource(R.drawable.x)
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    navController.navigate("RUTA Pendiente")
                }
            ) {
                Image(
                    painter = settings,
                    contentScale = ContentScale.Fit,
                    contentDescription = stringResource(id = R.string.setting),
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "Salir",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }


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

        OutlinedButton(
            onClick = { Toast.makeText(context, "Logging out...", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Text(
                text = "Logout",
                color = Color.Red,
                fontSize = 20.sp
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
fun SettingsPreview() {
    val navController = rememberNavController()
    Laboratorio4Theme {
        Settings("LAB#4 Mi Perfil", navController)
    }
}
