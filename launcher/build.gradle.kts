plugins {
    kotlin("jvm") version "1.9.0"

    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.bytemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {

}

tasks.withType<Jar> {
    archiveFileName.set("launcher.jar")

    manifest {
        attributes["Main-Class"] = "net.bytemc.bytecloud.launcher.LauncherKt"
    }
}