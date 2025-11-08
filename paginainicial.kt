package mx.ipn.upiicsa.dentiagenda.ui.theme.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
fun PaginaInicial() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // ---------- TÍTULO ----------
            Text(
                text = "DentiAgenda",
                fontSize = 34.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 31.dp),
                textAlign = TextAlign.Center
            )

            // ---------- MENÚ DESPLAZABLE ----------
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 84.dp)
                    .background(Color.White)
                    .height(75.dp)
                    .fillMaxWidth()
            ) {
                NuevoMenuButton("Datos Personales", Color(0xFFDFF5F8))
                NuevoMenuButton("Agendar Cita", Color(0xFFE4F9FB))
                NuevoMenuButton("Historial de citas", Color(0xFFE1F5F8))
            }

            // ---------- SECCIÓN DE PERFILES ----------
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Perfiles visitados anteriormente",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                PerfilItem("Usuario1 (Doctor/Doctora)", "usuarioemail@gmail.com")
                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")
                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")
                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Dentistas Cerca:",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )

                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")
                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")
                PerfilItem("Usuario (Doctor/Doctora)", "usuarioemail@gmail.com")
            }

            Spacer(modifier = Modifier.height(40.dp))

            // ---------- MENÚ INFERIOR ----------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_slideshow),
                    contentDescription = "Inicio",
                    tint = Color.Black,
                    modifier = Modifier.size(47.dp)
                )
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_search),
                    contentDescription = "Perfil",
                    tint = Color.Black,
                    modifier = Modifier.size(47.dp)
                )
                Icon(
                    painter = painterResource(android.R.drawable.sym_action_chat),
                    contentDescription = "Ajustes",
                    tint = Color.Black,
                    modifier = Modifier.size(47.dp)
                )
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

// ---------- COMPONENTES REUTILIZABLES ----------

@Composable
fun NuevoMenuButton(text: String, color: Color) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(color, RoundedCornerShape(8.dp))
            .width(120.dp)
            .height(75.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.Monospace,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PerfilItem(nombre: String, email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {
        Image(
            painter = painterResource(android.R.drawable.sym_def_app_icon),
            contentDescription = null,
            modifier = Modifier
                .size(47.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(
                text = nombre,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color(0xFF5F5D5D)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaginaInicial() {
    PaginaInicial()
}
