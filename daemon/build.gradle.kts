import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("plugin.serialization") version "1.9.0"
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
    compileOnly(libs.kotlinxserialization)
}

tasks.withType<Jar> {
    archiveFileName.set("daemon.jar")
}