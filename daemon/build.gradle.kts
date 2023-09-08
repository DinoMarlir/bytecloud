plugins {
    kotlin("jvm") version "1.9.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.bytemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://artifactory.bytemc.de/artifactory/bytemc-public/")
}

dependencies {
    implementation(project(":api"))
    compileOnly(project(":launcher"))

    compileOnly(libs.jline)
    compileOnly(libs.jansi)
    compileOnly(libs.netty5)
    compileOnly(libs.evelon)
}

tasks.withType<Jar> {
    archiveFileName.set("daemon.jar")
}