package com.bookstore.backend.utils

import org.springframework.stereotype.Component
import java.util.regex.Pattern

@Component
class ValidationUtil {
    private val emailPattern = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    )
    private val passwordPattern = Pattern.compile(
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    )
    fun isValidEmail(email: String): Boolean {
        return emailPattern.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return passwordPattern.matcher(password).matches()
    }
}
