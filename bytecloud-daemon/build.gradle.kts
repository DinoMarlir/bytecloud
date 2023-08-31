import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.bytemc.bytecloud"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.named("shadowJar", ShadowJar::class) {
    manifest {
        attributes["Main-Class"] = "net.bytemc.bytecloud.daemon.DaemonLauncherKt"
    }
    archiveFileName.set("bytecloud.jar")
}

dependencies {
    implementation(project(":bytecloud-api"))
    implementation(libs.jline)
    implementation(libs.h2)
    implementation(libs.jansi)
}