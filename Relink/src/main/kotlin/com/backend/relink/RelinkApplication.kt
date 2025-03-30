package com.backend.relink

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RelinkApplication

fun main(args: Array<String>) {
	runApplication<RelinkApplication>(*args)
}
