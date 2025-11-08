package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelefonoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 60.dp) // espacio para el menú inferior
    ) {
        // 🔹 Título superior
        Text(
            text = "DentiAgenda",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            textAlign = TextAlign.Center,
            fontSize = 34.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Barra de búsqueda
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "BÚSQUEDA DE DOCTORES",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .background(Color(0xFFCDFAF1), RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 🔹 Menú desplazable horizontal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .background(Color.White)
                .padding(vertical = 8.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BotonMenu("Datos Personales", Color(0xFFDFF5F8))
            BotonMenu("Agendar Cita", Color(0xFFE4F9FB))
            BotonMenu("Historial de citas", Color(0xFFE1F5F8))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🔹 Lista de doctores simulada
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(bottom = 90.dp)
        ) {
            items(3) { index ->
                // Llamamos correctamente a la función NewDoctorItem
                NewDoctorItem(
                    nombre = "Usuario (Doctor/Doctora)",
                    telefono = "Tel.: 5500000000"
                )
            }
        }
    }

    // 🔹 Menú inferior fijo
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        NewBottomMenu()
    }
}

// 🔸 Composable para botones del menú superior
@Composable
fun BotonMenu(text: String, color: Color) {
    Box(
        modifier = Modifier
            .background(color, RoundedCornerShape(8.dp))
            .clickable {}
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

// 🔸 Composable para cada doctor
@Composable
fun NewDoctorItem(nombre: String, telefono: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del doctor
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Foto doctor",
            tint = Color.Gray,
            modifier = Modifier.size(71.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = nombre,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = telefono,
                fontSize = 20.sp,
                color = Color(0xFF5F5D5D)
            )
        }
    }
}

// 🔸 Menú inferior (4 botones)
@Composable
fun NewBottomMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.Black)
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Black)
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.MailOutline, contentDescription = "Mensajes", tint = Color.Black)
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Default.Call, contentDescription = "Información", tint = Color(0xFF6591FB))
        }
    }
}
