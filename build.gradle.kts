plugins {
    kotlin("jvm") version "1.9.0"
}

group = "net.bytemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_20.toString()
        targetCompatibility = JavaVersion.VERSION_20.toString()
    }
}

kotlin {
    jvmToolchain(20)
}