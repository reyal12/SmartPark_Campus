package com.example.smartparkcampus.View.screen.reservation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReservationContent(onNavigateBack: () -> Unit) {
    var selectedSlot by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { 
                showSuccessDialog = false
                onNavigateBack()
            },
            title = { Text("Reservasi Berhasil") },
            text = { Text("Slot $selectedSlot telah berhasil dipesan untuk $duration jam.") },
            confirmButton = {
                Button(onClick = {
                    showSuccessDialog = false
                    onNavigateBack()
                }) {
                    Text("OK")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book a Slot") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = "Select your preferred parking slot", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = selectedSlot,
                onValueChange = { selectedSlot = it },
                label = { Text("Slot Number (e.g., A12)") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = duration,
                onValueChange = { duration = it },
                label = { Text("Estimated Duration (hours)") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Note: Your data is encrypted and stored securely.",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
            
            Button(
                onClick = { showSuccessDialog = true },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedSlot.isNotEmpty() && duration.isNotEmpty()
            ) {
                Text("Confirm Reservation")
            }
        }
    }
}
