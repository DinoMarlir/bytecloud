plugins {
    kotlin("jvm") version "1.9.0"
}

group = "net.bytemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gson)
}