package com.example.smartparkcampus.View.screen.register

import androidx.compose.runtime.Composable

@Composable
fun RegisterScreen(onNavigateBack: () -> Unit) {
    RegisterContent(
        onRegisterClick = { onNavigateBack() },
        onBackClick = { onNavigateBack() }
    )
}
