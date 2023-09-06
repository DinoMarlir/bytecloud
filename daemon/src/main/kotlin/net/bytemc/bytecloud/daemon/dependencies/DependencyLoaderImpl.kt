package net.bytemc.bytecloud.daemon.dependencies

import net.bytemc.bytecloud.api.dependencies.Dependency
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.launcher.loader.LauncherUrlClassLoader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.Path

class DependencyLoaderImpl : DependencyLoader {

    private var dependencyFolder = Path("dependencies")

    init {
        if (!Files.exists(dependencyFolder)) {
            Files.createDirectory(dependencyFolder)
        }

        Dependency("org.jline", "jline", "3.20.0").download(this)
        Dependency("org.fusesource.jansi", "jansi", "2.4.0").download(this)
        Dependency("io.netty", "netty5-all", "5.0.0.Alpha5").download(this)
    }

    override fun getDependencies(): List<Dependency> {
        TODO("Not yet implemented")
    }

    override fun addToClassPath(path: Path) {
        val classLoader = this.javaClass.classLoader as LauncherUrlClassLoader
        classLoader.addURL(path.toUri().toURL())
    }
}