package com.example.smartparkcampus.View.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: (LoginUiState) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onLoginSuccess(uiState)
        }
    }

    LoginContent(
        uiState = uiState,
        onLoginClick = { username, password ->
            viewModel.login(username, password)
        }
    )
}
