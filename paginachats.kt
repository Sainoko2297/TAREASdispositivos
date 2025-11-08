package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PaginaChats(
    onInicioClick: () -> Unit = {},
    onPerfilClick: () -> Unit = {},
    onAjustesClick: () -> Unit = {},
    onInfoClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onInicioClick = onInicioClick,
                onPerfilClick = onPerfilClick,
                onAjustesClick = onAjustesClick,
                onInfoClick = onInfoClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // ---------- Título principal ----------
            Text(
                text = "DentiAgenda",
                fontSize = 34.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ---------- Barra de búsqueda ----------
            SearchBar()

            Spacer(modifier = Modifier.height(20.dp))

            // ---------- Menú desplazable horizontal ----------
            HorizontalMenu()

            Spacer(modifier = Modifier.height(20.dp))

            // ---------- Lista de chats ----------
            DoctorList()
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .height(51.dp)
            .background(Color(0xFFCDFAF1), RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "BÚSQUEDA DE DOCTORES",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun HorizontalMenu() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 8.dp)
    ) {
        NHomeMenuButton("Datos Personales", Color(0xFFDFF5F8))
        Spacer(modifier = Modifier.width(8.dp))
        NHomeMenuButton("Agendar Cita", Color(0xFFE4F9FB))
        Spacer(modifier = Modifier.width(8.dp))
        NHomeMenuButton("Historial de citas", Color(0xFFE1F5F8))
    }
}

@Composable
fun NHomeMenuButton(text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DoctorList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.Start
    ) {
        DoctorCard("Usuario (Doctor/Doctora)", "Los mensajes se visualizan")
        DoctorCard("Usuario (Doctor/Doctora)", "TEXTTEXT")
        DoctorCard("Usuario (Doctor/Doctora)", "Mensajes X")
    }
}

@Composable
fun DoctorCard(nombre: String, descripcion: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(71.dp)
                .clip(CircleShape)
                .background(Color(0xFFEAEAEA))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = nombre, fontSize = 20.sp)
            Text(text = descripcion, fontSize = 18.sp, color = Color(0xFF5F5D5D))
        }
    }
}

@Composable
fun BottomNavigationBar(
    onInicioClick: () -> Unit,
    onPerfilClick: () -> Unit,
    onAjustesClick: () -> Unit,
    onInfoClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = onInicioClick) {
            Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.Black)
        }
        IconButton(onClick = onPerfilClick) {
            Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.Black)
        }
        IconButton(onClick = onAjustesClick) {
            Icon(Icons.Default.MailOutline, contentDescription = "Chats", tint = Color(0xFF6590FA))
        }
        IconButton(onClick = onInfoClick) {
            Icon(Icons.Default.Call, contentDescription = "Información", tint = Color.Black)
        }
    }
}
