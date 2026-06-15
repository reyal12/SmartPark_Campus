package com.example.smartparkcampus.data.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    @SerializedName("accessToken")
    val token: String,
    val refreshToken: String
)
