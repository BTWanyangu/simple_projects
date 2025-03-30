package com.backend.relink

import com.backend.relink.repositories.UserRepository
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RelinkApplicationTests {

	private val userRepository: UserRepository = mockk()
	private val userService = UserService(userRepository)

	@Test
	fun TODO() {
	}

}
