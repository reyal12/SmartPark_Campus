package com.example.smartparkcampus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlotMonitoringScreen(onNavigateBack: () -> Unit) {
    var slots by remember { mutableStateOf(List(20) { it % 3 == 0 }) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(2000) 
            slots = slots.map { Math.random() > 0.5 }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Real-time Slot Monitoring") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LegendItem(Color.Green, "Available")
                LegendItem(Color.Red, "Occupied")
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(slots.size) { index ->
                    ParkingSlotItem(index + 1, slots[index])
                }
            }
        }
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(16.dp).background(color, androidx.compose.foundation.shape.RoundedCornerShape(4.dp)))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ParkingSlotItem(number: Int, isAvailable: Boolean) {
    Card(
        modifier = Modifier.aspectRatio(1f),
        colors = CardDefaults.cardColors(
            containerColor = if (isAvailable) Color.Green.copy(alpha = 0.2f) else Color.Red.copy(alpha = 0.2f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, if (isAvailable) Color.Green else Color.Red)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "A$number", style = MaterialTheme.typography.titleMedium)
        }
    }
}
