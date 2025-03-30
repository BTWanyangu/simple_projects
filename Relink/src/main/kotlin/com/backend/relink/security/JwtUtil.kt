package com.backend.relink.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {

    private val secretKey = "mySecretKey123456"

    fun generateToken(email: String): String {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
            .signWith(SignatureAlgorithm.HS256, secretKey.toByteArray())
            .compact()
    }

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser().setSigningKey(secretKey.toByteArray()).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun extractEmail(token: String): String {
        return Jwts.parser().setSigningKey(secretKey.toByteArray()).parseClaimsJws(token).body.subject
    }
}