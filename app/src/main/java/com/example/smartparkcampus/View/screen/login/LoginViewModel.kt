package com.example.smartparkcampus.View.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartparkcampus.data.model.request.LoginRequest
import com.example.smartparkcampus.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val response = repository.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    val userData = response.body()
                    _uiState.update { it.copy(
                        isLoading = false, 
                        isSuccess = true,
                        firstName = userData?.firstName,
                        lastName = userData?.lastName,
                        email = userData?.email,
                        image = userData?.image
                    ) }
                } else {
                    _uiState.update { it.copy(isLoading = false, error = "Login Failed: Invalid credentials") }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message ?: "An unexpected error occurred") }
            }
        }
    }
}
