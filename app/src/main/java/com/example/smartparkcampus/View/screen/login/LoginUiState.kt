package com.example.smartparkcampus.View.screen.login

data class LoginUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val image: String? = null,
    val error: String? = null
)
