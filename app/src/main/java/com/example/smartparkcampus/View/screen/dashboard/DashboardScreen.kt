package com.example.smartparkcampus.View.screen.dashboard

import androidx.compose.runtime.Composable

@Composable
fun DashboardScreen(
    firstName: String,
    lastName: String,
    email: String,
    image: String,
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit,
    onProfileClick: () -> Unit
) {
    DashboardContent(
        name = firstName,
        onNavigate = onNavigate,
        onLogout = onLogout,
        onProfileClick = onProfileClick
    )
}
