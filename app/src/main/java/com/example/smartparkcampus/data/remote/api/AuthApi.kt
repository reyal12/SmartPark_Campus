package com.example.smartparkcampus.data.remote.api

import com.example.smartparkcampus.data.endpoint.EndPoint
import com.example.smartparkcampus.data.model.request.LoginRequest
import com.example.smartparkcampus.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(EndPoint.LOGIN)
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>
}
