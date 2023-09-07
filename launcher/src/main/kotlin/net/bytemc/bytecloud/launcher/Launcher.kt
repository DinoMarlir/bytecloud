package net.bytemc.bytecloud.launcher

import net.bytemc.bytecloud.launcher.checks.JavaVersion
import net.bytemc.bytecloud.launcher.loader.LauncherUrlClassLoader
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

fun main(args: Array<String>) {
    // main application class loader
    val mainClassLoader = LauncherUrlClassLoader(Path.of("daemon.jar").toUri().toURL())

    // todo change maybe to extra launcher -> not java 8 compiled
    if(JavaVersion.canLaunch()) {
        error("Cannot run with this java version (Java ${JavaVersion.version()})")
    }
     mainClassLoader.loadClass("net.bytemc.bytecloud.daemon.DaemonLauncherKt").getDeclaredMethod("main", Array<String>::class.java).invoke(null, args)
}