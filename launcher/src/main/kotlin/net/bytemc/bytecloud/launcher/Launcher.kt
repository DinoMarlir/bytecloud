package net.bytemc.bytecloud.launcher

import net.bytemc.bytecloud.launcher.loader.LauncherUrlClassLoader
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

fun main(args: Array<String>) {

    println("polo")

    var classLoader = ClassLoader.getSystemClassLoader();

    // copy file form launcher in storage
    classLoader.getResourceAsStream("daemon.jar")?.let {
        Files.copy(
            it, Path.of("daemon.jar"), StandardCopyOption.REPLACE_EXISTING
        )
    }

    // main application class loader
    var mainClassLoader = LauncherUrlClassLoader(Path.of("daemon.jar").toUri().toURL())

     mainClassLoader.loadClass("net.bytemc.bytecloud.daemon.DaemonLauncherKt").getDeclaredMethod("main", Array<String>::class.java).invoke(null, args)
}