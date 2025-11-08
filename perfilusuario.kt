package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PerfilUsuario() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            // -------- TÍTULO SUPERIOR --------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /* TODO: acción del ícono izquierdo */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.sym_def_app_icon),
                        contentDescription = null,
                        modifier = Modifier.size(36.dp),
                        tint = Color.Black
                    )
                }

                Text(
                    text = "DentiAgenda",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                IconButton(onClick = { /* TODO: acción del ícono derecho */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.sym_def_app_icon),
                        contentDescription = null,
                        modifier = Modifier.size(47.dp),
                        tint = Color.Black
                    )
                }
            }

            // -------- MENÚ DESPLAZABLE --------
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 40.dp)
                    .height(75.dp)
            ) {
                MenuItemPerfil("Datos Personales", Color(0xFF0097BD))
                MenuItemPerfil("Agendar Cita", Color(0xFFE4F9FB))
                MenuItemPerfil("Historial de citas", Color(0xFFE1F5F8))
            }

            // -------- IMAGEN DE PERFIL --------
            Image(
                painter = painterResource(android.R.drawable.sym_def_app_icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(175.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)
            )

            // -------- INFORMACIÓN DEL USUARIO --------
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Usuario",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Nombre del Usuario",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Dirección",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Dirección del Cliente",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Teléfono",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "5500000000 (numero)",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Correo Electrónico",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "example@gmail.com",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            // -------- BOTÓN EDITAR --------
            Button(
                onClick = { /* TODO: acción editar */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier
                    .width(111.dp)
                    .height(45.dp)
                    .align(Alignment.Start)
            ) {
                Text(
                    text = "EDITAR",
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            // -------- MENÚ INFERIOR --------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_slideshow),
                        contentDescription = "Inicio",
                        tint = Color.Black,
                        modifier = Modifier.size(47.dp)
                    )
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_search),
                        contentDescription = "Perfil",
                        tint = Color.Black,
                        modifier = Modifier.size(47.dp)
                    )
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.sym_action_chat),
                        contentDescription = "Ajustes",
                        tint = Color.Black,
                        modifier = Modifier.size(47.dp)
                    )
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        painter = painterResource(android.R.drawable.stat_sys_phone_call),
                        contentDescription = "Info",
                        tint = Color.Black,
                        modifier = Modifier.size(47.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MenuItemPerfil(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .width(120.dp)
            .height(75.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPerfilUsuario() {
    PerfilUsuario()
}
