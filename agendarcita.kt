package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable



@Composable
fun AgendarCitaScreen() {
    val scrollState = rememberScrollState()
    var selectedDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // 🔹 Encabezado superior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DentiAgenda",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )

            // Imagen de perfil (puedes reemplazar por painterResource con tu drawable)
            IconButton(onClick = { /* Acción perfil */ }) {
                Icon(
                    painter = painterResource(R.drawable.ic_menu_gallery),
                    contentDescription = "Perfil",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        // 🔹 Menú horizontal superior
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp)
        ) {
            MyMenuButton(text = "Datos Personales", background = Color(0xFFDFF5F8))
            MyMenuButton(text = "Agendar Cita", background = Color(0xFF0198BD))
            MyMenuButton(text = "Historial de Citas", background = Color(0xFFE1F5F8))
        }

        // 🔹 Texto informativo
        Text(
            text = "Para poder ver los doctores disponibles, primero escoge el día y el mes a agendar ^-^",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )

        // 🔹 Calendario simple (no nativo en Compose aún)
        Spacer(modifier = Modifier.height(24.dp))
        DatePickerView(onDateSelected = { date ->
            selectedDate = date
        })

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Botón principal
        Button(
            onClick = { /* Acción para ver doctores disponibles */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(240.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("DOCTORES DISPONIBLES", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Menú inferior con iconos
        BottomMenu()
    }
}

// 🔹 Botón de menú horizontal
@Composable
fun MyMenuButton(text: String, background: Color) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(background)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

// 🔹 Menú inferior (botones con iconos)
@Composable
fun BottomMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.ic_menu_slideshow),
                contentDescription = "Inicio"
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.ic_menu_search),
                contentDescription = "Perfil"
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.sym_action_chat),
                contentDescription = "Ajustes"
            )
        }
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.stat_sys_phone_call),
                contentDescription = "Información"
            )
        }
    }
}

// 🔹 Componente de selección de fecha (simulado)
@Composable
fun DatePickerView(onDateSelected: (String) -> Unit) {
    var dateText by remember { mutableStateOf("Selecciona una fecha") }

    Button(onClick = {
        // Simula seleccionar una fecha actual
        val today = Calendar.getInstance()
        val date =
            "${today.get(Calendar.DAY_OF_MONTH)}/${today.get(Calendar.MONTH) + 1}/${today.get(Calendar.YEAR)}"
        dateText = date
        onDateSelected(date)
    }) {
        Text(text = dateText)
    }
}
