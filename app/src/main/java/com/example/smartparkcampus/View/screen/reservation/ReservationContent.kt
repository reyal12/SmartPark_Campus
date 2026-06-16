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
                title = { Text("Pesan Slot") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
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
            Text(text = "Pilih slot parkir yang Anda inginkan", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = selectedSlot,
                onValueChange = { selectedSlot = it },
                label = { Text("Nomor Slot (misal: A12)") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = duration,
                onValueChange = { duration = it },
                label = { Text("Estimasi Durasi (jam)") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Catatan: Data Anda dienkripsi dan disimpan dengan aman.",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
            
            Button(
                onClick = { showSuccessDialog = true },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedSlot.isNotEmpty() && duration.isNotEmpty()
            ) {
                Text("Konfirmasi Reservasi")
            }
        }
    }
}
