package com.backend.relink.services

import com.backend.relink.models.User
import com.backend.relink.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUserById(id: String): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}
