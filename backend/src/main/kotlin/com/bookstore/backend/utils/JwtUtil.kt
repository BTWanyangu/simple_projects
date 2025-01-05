package com.bookstore.backend.utils

import org.springframework.stereotype.Component
import java.util.*
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

@Component
class JwtUtil {
    private val secret = "secret"
    private val expirationTime = 3600000

    fun generateToken(email: String): String{
        val claims: Map<String, Any> = mapOf("email" to email)
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(email)
        .setIssuedAt(Date())
        .setExpiration(Date(System.currentTimeMillis() + expirationTime))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact()

    }
    fun generateRefreshToken(email: String): String{
        return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(Date())
        .setExpiration(Date(System.currentTimeMillis() + expirationTime))
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact()
    }
    fun validateToken(token: String): Boolean{
        try{
            val claims = getClaims(token)
            return !claims.expiration.before(Date())
        } catch (e: Exception){
            return false
        }
    }
    fun extractEmail(token: String): String?{
        return getClaims(token).subject
    }
    private fun getClaims(token: String): Claims{
        return Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .body
    }
}