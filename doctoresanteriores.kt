package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.ipn.upiicsa.dentiagenda.R

@Composable
fun BusquedaDoctoresScreen() {

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        // Título principal
        Text(
            text = "DentiAgenda",
            fontSize = 34.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Menú desplazable horizontal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            // Sustituye por tu MyMenuButton si existe
            NewMenuButton("Datos Personales", Color(0xFFDFF5F8))
            Spacer(modifier = Modifier.width(8.dp))
            NewMenuButton("Agendar Cita", Color(0xFFE4F9FB))
            Spacer(modifier = Modifier.width(8.dp))
            NewMenuButton("Historial de Citas", Color(0xFFE1F5F8))
        }

        // Texto superior
        Text(
            text = "BÚSQUEDA DE DOCTORES",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
        )

        // Barra de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Búsqueda de doctores") },
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .background(Color(0xFFCDFAF1), RoundedCornerShape(8.dp)),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFCDFAF1),
                unfocusedContainerColor = Color(0xFFCDFAF1),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        // Título de resultados
        Text(
            text = "RESULTADOS:",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        )

        // Resultados simulados
        repeat(4) {
            DoctorItem(
                nombre = "Usuario (Doctor/Doctora)",
                correo = "usuarioemail@gmail.com"
            )
        }

        // Filtro
        Text(
            text = "Filtrar doctores por:",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Botones de filtro
        Button(
            onClick = { /* Acción: Anteriormente consultados */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 40.dp, end = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEEEEEE))
        ) {
            Text("Anteriormente Consultados", color = Color.Black)
        }

        Button(
            onClick = { /* Acción: Cercanos a tu ubicación */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 40.dp, end = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEEEEEE))
        ) {
            Text("Cercanos a tu ubicación", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menú inferior (usa tu versión real)
        BottomMenu()
    }
}

@Composable
fun NewMenuButton(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .width(130.dp)
            .height(75.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
fun DoctorItem(nombre: String, correo: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto del doctor",
            modifier = Modifier
                .size(47.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(nombre, fontSize = 16.sp, color = Color.Black)
            Text(correo, fontSize = 14.sp, color = Color(0xFF5F5D5D))
        }
    }
}
