plugins {
    kotlin("jvm") version "2.2.20"
}

group = "advent"
version = "2025"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}