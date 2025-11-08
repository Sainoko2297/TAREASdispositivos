package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.ipn.upiicsa.dentiagenda.R

@Composable
fun MainScreen() {
    // Estado del spinner
    var selectedDoctor by remember { mutableStateOf("Selecciona un doctor") }

    // Scroll general
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        // ---------- TÍTULO SUPERIOR ----------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "DentiAgenda",
                fontSize = 34.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo",
                modifier = Modifier.size(47.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---------- MENÚ DESPLAZABLE HORIZONTAL ----------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            HomeMenuButton("Datos Personales", Color(0xFFDFF5F8))
            Spacer(modifier = Modifier.width(8.dp))
            HomeMenuButton("Agendar Cita", Color(0xFF0198BD))
            Spacer(modifier = Modifier.width(8.dp))
            HomeMenuButton("Historial de citas", Color(0xFFE1F5F8))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------- SPINNER DE DOCTORES ----------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            // Simulación de Spinner
            var expanded by remember { mutableStateOf(false) }
            Column {
                OutlinedButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(selectedDoctor, color = Color.Black)
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf("Dr. García", "Dra. López", "Dr. Hernández").forEach { doctor ->
                        DropdownMenuItem(
                            text = { Text(doctor) },
                            onClick = {
                                selectedDoctor = doctor
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- TABLA DE HORARIOS ----------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF6F6F6))
                .padding(8.dp)
        ) {
            val tabla = listOf(
                listOf("Hora X", "Hora Y"),
                listOf("Hora B", "Hora A"),
                listOf("Hora C", "Hora D")
            )
            tabla.forEach { fila ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    fila.forEach { hora ->
                        Button(
                            onClick = { /* Acción */ },
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            Text(hora)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- BOTÓN PRINCIPAL ----------
        Button(
            onClick = { /* Acción Agendar */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(163.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("AGENDAR CITA", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ---------- MENÚ INFERIOR ----------
        MyBottomMenu()
    }
}



@Composable
fun HomeMenuButton(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .width(120.dp)
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
fun HomeMenuButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val icons = listOf(
            android.R.drawable.ic_menu_slideshow,
            android.R.drawable.ic_menu_search,
            android.R.drawable.sym_action_chat,
            android.R.drawable.stat_sys_phone_call
        )
        icons.forEachIndexed { index, icon ->
            IconButton(onClick = { /* Acción según icono */ }) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Opción ${index + 1}",
                    tint = Color.Black
                )
            }
        }
    }
}
