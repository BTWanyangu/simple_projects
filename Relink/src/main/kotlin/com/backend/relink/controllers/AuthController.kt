package com.backend.relink.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.backend.relink.security.JwtUtil
import com.backend.relink.services.AuthService

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService, private val jwtUtil: JwtUtil) {

    data class SignupRequest(val username: String, val email: String, val password: String, val age: Int, val gender: String)
    data class LoginRequest(val email: String, val password: String)

    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest): ResponseEntity<String> {
        val response = authService.signup(request.username, request.email, request.password, request.age, request.gender)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Map<String, String>> {
        val result = authService.signin(request.email, request.password)

        return if (result.startsWith("Signin successful")) {
            val token = jwtUtil.generateToken(request.email)
            ResponseEntity.ok(mapOf("token" to token))
        } else {
            ResponseEntity.badRequest().body(mapOf("error" to result))
        }
    }
}