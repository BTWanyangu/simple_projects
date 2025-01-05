package com.bookstore.backend.service

import com.bookstore.backend.entity.*
import com.bookstore.backend.dto.*
import com.bookstore.backend.repository.UserRepository
import com.bookstore.backend.utils.JwtUtil
import org.apache.coyote.BadRequestException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil
){
    fun registerUser(request: AuthRequest): String{
        if (userRepository.existsByEmail(request.email)){
            throw BadRequestException("Email already exists")
        }
        val user = User(
            email = request.email,
            password = passwordEncoder.encode(request.password),
            firstName = request.firstName,
            lastName = request.lastName,
            phoneNumber = request.phoneNumber,
            address = request.address
        )
        userRepository.save(user)
        return "User registered successfully"

    }
    fun loginUser(request: AuthRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            .orElseThrow { BadRequestException("Email does not exist") } // Ensure safe retrieval

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw BadRequestException("Passwords do not match")
        }

        val accessToken = jwtUtil.generateToken(user.email)
        val refreshToken = jwtUtil.generateRefreshToken(user.email)
        return AuthResponse(accessToken, refreshToken)
    }

    fun getUserById(id: Long): UserResponse{
        val user = userRepository.findById(id).orElseThrow{BadRequestException("User not found")}
        return UserResponse(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            phoneNumber = user.phoneNumber,
            address = user.address,
            balance = user.balance
        )
    }
    fun updateUser(id: Long, request: UpdateUserRequest){
        val user = userRepository.findById(id).orElseThrow{BadRequestException("User not found")}
        user.apply{
            firstName  =request.firstName
            lastName = request.lastName
            phoneNumber = request.phoneNumber
            address = request.address
        }
        userRepository.save(user)
    }
}