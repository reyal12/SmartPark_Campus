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
        address = "Jl. Kampus Smart Park No. 1", // Placeholder as DummyJSON login doesn't provide address
        onNavigateBack = onNavigateBack
    )
}
