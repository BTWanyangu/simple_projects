package com.backend.relink.services

import com.backend.relink.repositories.UserRepository
import org.springframework.stereotype.Service
import at.favre.lib.crypto.bcrypt.BCrypt
import com.backend.relink.models.User

@Service
class AuthService(private val userRepository: UserRepository) {

    fun signup(username: String, email: String, password: String, age: Int, gender: String): String {
        // Check if user already exists
        if (userRepository.findByEmail(email) != null) {
            return "Error: Email already registered"
        }

        // Hash password
        val hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray())

        // Create and save user
        val newUser = User(username = username, email = email, password = hashedPassword, age = age, gender = gender)
        userRepository.save(newUser)

        return "Signup successful!"
    }

    fun signin(email: String, password: String): String {
        val user = userRepository.findByEmail(email) ?: return "Error: User not found"

        // Verify password
        val result = BCrypt.verifyer().verify(password.toCharArray(), user.password)
        return if (result.verified) "Signin successful! Welcome, ${user.username}" else "Error: Incorrect password"
    }
}