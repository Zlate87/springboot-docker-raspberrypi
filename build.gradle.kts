import org.jetbrains.kotlin.daemon.nowSeconds
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("com.palantir.docker") version "0.25.0"
	kotlin("plugin.spring") version "1.4.21"
	kotlin("jvm") version "1.4.21"
}

group = "com.zlate87"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

docker {
	name = "zlate87/springboot-docker-raspberrypi"
	setDockerfile(File("docker/Dockerfile"))
	files( "build/libs/springboot-docker-raspberrypi.jar")
	tag("latest", "zlate87/springboot-docker-raspberrypi:latest")
	tag("timestamp", "zlate87/springboot-docker-raspberrypi:${nowSeconds()}")
}