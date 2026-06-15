package com.example.smartparkcampus.data.repository

import com.example.smartparkcampus.data.model.request.LoginRequest
import com.example.smartparkcampus.data.model.response.LoginResponse
import com.example.smartparkcampus.data.remote.api.AuthApi
import retrofit2.Response

class AuthRepository(private val authApi: AuthApi) {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return authApi.login(request)
    }
}
