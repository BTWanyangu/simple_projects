plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.backend"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-integration")
	//implementation("org.springframework.integration:spring-integration-security")
	implementation("org.springframework.integration:spring-integration-http")
	implementation("org.springframework.integration:spring-integration-websocket")
	implementation("org.springframework.integration:spring-integration-stomp")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.integration:spring-integration-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	// JWT for Authentication
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// Password Hashing (BCrypt)
	implementation("org.springframework.security:spring-security-crypto")
		implementation("at.favre.lib:bcrypt:0.9.0")


	// Database ORM (MongoDB with Spring Data)
	implementation("org.litote.kmongo:kmongo:4.10.0")

	// WebSockets (For real-time messaging)
	implementation("org.springframework.boot:spring-boot-starter-websocket")

	// Subscription & Payments (Stripe SDK for Payments)
	implementation("com.stripe:stripe-java:22.7.0")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.13.5") // For mocking in Kotlin
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0") // JUnit 5
	testImplementation("org.assertj:assertj-core:3.24.2") // Optional: AssertJ for better assertions

}


kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
