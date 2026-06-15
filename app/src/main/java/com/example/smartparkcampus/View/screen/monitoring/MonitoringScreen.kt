package com.example.smartparkcampus.View.screen.monitoring

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun MonitoringScreen(onNavigateBack: () -> Unit) {
    // Mocking real-time state. 
    var slots by remember { mutableStateOf(List(20) { it % 3 == 0 }) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(2000) 
            slots = slots.map { Math.random() > 0.5 }
        }
    }

    MonitoringContent(
        slots = slots,
        onNavigateBack = onNavigateBack
    )
}
