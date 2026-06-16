package com.example.smartparkcampus.View.screen.profile

import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen(
    firstName: String,
    lastName: String,
    email: String,
    image: String,
    onNavigateBack: () -> Unit
) {
    ProfileContent(
        firstName = firstName,
        lastName = lastName,
        email = email,
        image = image,
        address = "Jl. Kampung Baru",
        onNavigateBack = onNavigateBack
    )
}
