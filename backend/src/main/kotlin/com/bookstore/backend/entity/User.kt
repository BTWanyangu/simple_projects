package com.bookstore.backend.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    var firstName: String,

    @Column(nullable = false)
    var lastName: String,

    @Column(nullable = false, unique = true)
    var phoneNumber: String,

    @Column(nullable = false)
    var address: String,

    @Column(nullable = true)
    val balance: Double = 0.0, // Track user account balance for refunds or credits

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    @CreatedDate
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

enum class Role {
    USER, ADMIN, DELIVERY_AGENT
}
