package com.bookstore.backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class AuthRequest(
    @field:Email
    @field:NotBlank(message = "Email is required")
    val email: String,

    @field:NotBlank
    @field:Size(min = 8, message = "Password must be at least 8 characters long")
    val password: String,

    @field:NotBlank
    val firstName: String,

    @field:NotBlank
    val lastName: String,

    @field:NotBlank
    val phoneNumber: String,

    @field:NotBlank
    val address: String
)

data class UpdateUserRequest(
    @field:NotBlank
    val firstName: String,

    @field:NotBlank
    val lastName: String,

    @field:NotBlank
    val phoneNumber: String,

    @field:NotBlank
    val address: String
)