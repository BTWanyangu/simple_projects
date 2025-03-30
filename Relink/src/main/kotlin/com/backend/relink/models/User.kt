package com.backend.relink.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "users")
data class User(
    @Id val id: String? = null,
    val username: String,
    val email: String,
    val password: String,
    val bio: String? = null,
    val age: Int,
    val gender: String,
    val interests: List<String> = listOf(),

)


