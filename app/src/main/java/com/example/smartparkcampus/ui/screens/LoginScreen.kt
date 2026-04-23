package com.example.smartparkcampus.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.smartparkcampus.navigation.Screen

@Composable
fun LoginScreen(onNavigateToRegister: () -> Unit, onNavigateToDashboard: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Smart Park Campus", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username (Mahasiswa/Dosen/Admin)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onNavigateToDashboard,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        

        Text(text = "Lupa Password? Hubungi Admin IT Kampus", style = MaterialTheme.typography.bodySmall)
        
        TextButton(onClick = onNavigateToRegister) {
            Text("Don't have an account? Register")
        }
    }
}
