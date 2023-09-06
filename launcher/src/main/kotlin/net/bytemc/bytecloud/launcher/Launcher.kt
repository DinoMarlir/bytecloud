package net.bytemc.bytecloud.launcher

import net.bytemc.bytecloud.launcher.loader.LauncherUrlClassLoader
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

fun main(args: Array<String>) {
    // main application class loader
    var mainClassLoader = LauncherUrlClassLoader(Path.of("daemon.jar").toUri().toURL())

     mainClassLoader.loadClass("net.bytemc.bytecloud.daemon.DaemonLauncherKt").getDeclaredMethod("main", Array<String>::class.java).invoke(null, args)
}