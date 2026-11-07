
package com.atscloud.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Fondo = Color(0xFF080E18)
private val Panel = Color(0xFF111E30)
private val Azul = Color(0xFF168BFF)
private val Texto = Color(0xFFF4F7FC)
private val Secundario = Color(0xFF9DB1C9)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var estado by remember {
                mutableStateOf("Servidor pendiente de configurar")
            }

            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Fondo
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFF10243D),
                                        Fondo,
                                        Color(0xFF080E18)
                                    )
                                )
                            )
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(18.dp)
                    ) {

                        // ENCABEZADO
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                color = Azul,
                                shape = RoundedCornerShape(14.dp)
                            ) {
                                Text(
                                    text = "ATS",
                                    modifier = Modifier.padding(
                                        horizontal = 12.dp,
                                        vertical = 10.dp
                                    ),
                                    color = Color.White,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 22.sp
                                )
                            }

                            Spacer(Modifier.width(12.dp))

                            Column {
                                Text(
                                    "ATS CLOUD",
                                    color = Texto,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    "CLOUD GAMING PLATFORM",
                                    color = Secundario,
                                    fontSize = 10.sp,
                                    letterSpacing = 2.sp
                                )
                            }
                        }

                        // PRESENTACIÓN
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Panel
                            ),
                            shape = RoundedCornerShape(22.dp),
                            border = BorderStroke(1.dp, Color(0xFF24476C))
                        ) {
                            Column(
                                modifier = Modifier.padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text(
                                    "TU CAMIÓN. TU MUNDO.",
                                    color = Texto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Black
                                )

                                Text(
                                    "Tu experiencia de conducción comienza aquí.",
                                    color = Secundario,
                                    fontSize = 14.sp
                                )

                                Surface(
                                    color = Color(0xFF183A5D),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "🚛",
                                            fontSize = 55.sp
                                        )
                                    }
                                }

                                Text(
                                    "AMERICAN TRUCK SIMULATOR",
                                    color = Azul,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                            }
                        }

                        // CONEXIÓN
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                "SERVIDOR GAMING",
                                color = Texto,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Panel
                                ),
                                shape = RoundedCornerShape(18.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Text(
                                        "Estado de conexión",
                                        color = Secundario
                                    )

                                    Text(
                                        estado,
                                        color = if (estado == "Desconectado")
                                            Color(0xFFFFB74D)
                                        else
                                            Color(0xFF62B5FF),
                                        fontWeight = FontWeight.Bold
                                    )

                                    Button(
                                        onClick = {
                                            estado =
                                                "Servidor pendiente de configurar"
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Azul
                                        ),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text(
                                            "CONECTAR AL SERVIDOR",
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    OutlinedButton(
                                        onClick = {
                                            estado = "Desconectado"
                                        },
                                        modifier = Modifier.fillMaxWidth(),
                                        border = BorderStroke(1.dp, Azul),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text("DESCONECTAR")
                                    }
                                }
                            }
                        }

                        // SECCIONES
                        Text(
                            "CENTRO DE CONTROL",
                            color = Texto,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        ControlCard(
                            titulo = "MIS JUEGOS",
                            descripcion = "American Truck Simulator",
                            simbolo = "🎮"
                        )

                        ControlCard(
                            titulo = "MIS MODS",
                            descripcion = "Steam Workshop y mods externos",
                            simbolo = "📦"
                        )

                        ControlCard(
                            titulo = "RENDIMIENTO",
                            descripcion = "Calidad de imagen y conexión",
                            simbolo = "⚡"
                        )

                        ControlCard(
                            titulo = "CONFIGURACIÓN",
                            descripcion = "Preferencias de ATS CLOUD",
                            simbolo = "⚙"
                        )

                        Text(
                            "ATS CLOUD • VERSIÓN 1.0",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            color = Secundario,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ControlCard(
    titulo: String,
    descripcion: String,
    simbolo: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Panel
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFF203750))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                simbolo,
                fontSize = 27.sp
            )

            Spacer(Modifier.width(14.dp))

            Column {
                Text(
                    titulo,
                    color = Texto,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    descripcion,
                    color = Secundario,
                    fontSize = 12.sp
                )
            }
        }
    }
}
