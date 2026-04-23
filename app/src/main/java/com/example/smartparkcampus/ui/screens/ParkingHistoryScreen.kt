package com.example.smartparkcampus.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkingHistoryScreen(onNavigateBack: () -> Unit) {
    val historyItems = listOf(
        HistoryRecord("B 1234 ABC", "Gedung A", "2023-10-27 10:30"),
        HistoryRecord("B 1234 ABC", "Gedung B", "2023-10-25 08:15"),
        HistoryRecord("B 1234 ABC", "Lapangan Parkir Utara", "2023-10-24 13:00"),
        HistoryRecord("B 1234 ABC", "Gedung A", "2023-10-22 09:45")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parking History") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(historyItems) { record ->
                HistoryCard(record)
            }
        }
    }
}

data class HistoryRecord(val plate: String, val location: String, val timestamp: String)

@Composable
fun HistoryCard(record: HistoryRecord) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = record.plate, style = MaterialTheme.typography.titleMedium)
                Text(text = record.timestamp, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Location: ${record.location}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
