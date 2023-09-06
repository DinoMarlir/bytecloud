package net.bytemc.bytecloud.daemon.dependencies

import net.bytemc.bytecloud.api.dependencies.Dependency
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import kotlin.io.path.Path

class DependencyLoaderImpl : DependencyLoader {

    private var dependencyFolder = Path("dependencies")

    init {
        if(!Files.exists(dependencyFolder)) {
            Files.createDirectory(dependencyFolder)
        }

        Dependency("org.jline", "jline", "3.20.0").download()

    }

    override fun getDependencies(): List<Dependency> {
        TODO("Not yet implemented")
    }
}