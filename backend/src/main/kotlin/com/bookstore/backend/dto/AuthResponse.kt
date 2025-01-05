package com.bookstore.backend.dto

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
)
data class UserResponse(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val balance: Double
)