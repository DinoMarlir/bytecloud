pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "bytecloud"
include("bytecloud-daemon")
include("bytecloud-api")
include("bytecloud-modules")
include("bytecloud-updater")
