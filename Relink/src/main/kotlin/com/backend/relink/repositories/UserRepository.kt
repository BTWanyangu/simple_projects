package com.backend.relink.repositories

import com.backend.relink.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}