package com.bookstore.backend.controller

import com.bookstore.backend.dto.*
import com.bookstore.backend.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class AuthController(private val authService: AuthService) {
    @PostMapping("/signup")
    fun registerUser(@Valid @RequestBody request: AuthRequest): ResponseEntity<String> {
       val message = authService.registerUser(request)
       return ResponseEntity.ok(message)
    }

    @PostMapping("/login")
    fun loginUser(@Valid @RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        val authResponse = authService.loginUser(request)
        return ResponseEntity.ok(authResponse)
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    fun getUserDetails(@PathVariable id: Long): ResponseEntity<UserResponse> {
       val user = authService.getUserById(id)
        return ResponseEntity.ok(user)
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    fun updateUserDetails(@PathVariable id: Long, @Valid @RequestBody request: UpdateUserRequest): ResponseEntity<String>{
        authService.updateUser(id,request)
        return ResponseEntity.ok("User updated successfully")
    }
}