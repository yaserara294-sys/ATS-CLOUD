package com.atscloud.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var conectado by remember { mutableStateOf(false) }

            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "ATS CLOUD",
                            style = MaterialTheme.typography.headlineLarge
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "American Truck Simulator",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Button(
                            onClick = { conectado = true },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("JUGAR")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedButton(
                            onClick = { conectado = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("DESCONECTAR")
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = if (conectado)
                                "Preparando conexión..."
                            else
                                "Desconectado"
                        )
                    }
                }
            }
        }
    }
}
