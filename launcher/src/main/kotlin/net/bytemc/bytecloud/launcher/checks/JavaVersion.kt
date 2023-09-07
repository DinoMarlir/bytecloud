package net.bytemc.bytecloud.launcher.checks

object JavaVersion {

    private var MINIMAL_VERSION = 17

    fun version(): Int {
        val versionProperty = System.getProperty("java.version")
        val versionString = versionProperty.split(".")[0]
        return versionString.toInt()
    }

    fun canLaunch(): Boolean {
        return version() >= MINIMAL_VERSION;
    }
}