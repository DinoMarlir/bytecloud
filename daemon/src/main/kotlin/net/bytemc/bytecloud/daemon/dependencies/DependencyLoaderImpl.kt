package net.bytemc.bytecloud.daemon.dependencies

import net.bytemc.bytecloud.api.dependencies.Dependency
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.configuration.impl.ProxyConfiguration
import net.bytemc.bytecloud.daemon.misc.ProxyConnection
import net.bytemc.bytecloud.daemon.terminal.utils.Color
import net.bytemc.bytecloud.launcher.loader.LauncherUrlClassLoader
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.Path

class DependencyLoaderImpl(private var configuration: ProxyConfiguration) : DependencyLoader {

    private val dependencyFolder = Path("dependencies")
    private val loadedDependencies = ArrayList<Dependency>()

    init {
        if (!Files.exists(dependencyFolder)) {
            Files.createDirectory(dependencyFolder)
        }

        this.load(Dependency("org.jline", "jline", "3.20.0"))
        this.load(Dependency("org.fusesource.jansi", "jansi", "2.4.0"))



        this.load(Dependency("io.netty", "netty5-common", "5.0.0.Alpha5"))
        this.load(Dependency("io.netty", "netty5-codec", "5.0.0.Alpha5"))
        this.load(Dependency("io.netty", "netty5-buffer", "5.0.0.Alpha5"))
        this.load(Dependency("io.netty", "netty5-resolver", "5.0.0.Alpha5"))
        this.load(Dependency("io.netty", "netty5-transport", "5.0.0.Alpha5"))

        this.load(Dependency("io.netty", "netty5-transport-classes-epoll", "5.0.0.Alpha5"))
        this.load(Dependency("io.netty", "netty5-transport-native-epoll", "5.0.0.Alpha5",  "linux-x86_64", "https://repo.maven.apache.org/maven2/"))
        this.load(Dependency("io.netty", "netty5-transport-native-epoll", "5.0.0.Alpha5", "linux-aarch_64", "https://repo.maven.apache.org/maven2/"))
        this.load(Dependency("io.netty", "netty5-transport-native-unix-common", "5.0.0.Alpha5"))

        this.load(
            Dependency(
                "net.bytemc",
                "evelon",
                "1.2.2-SNAPSHOT",
                "shaded",
                "https://artifactory.bytemc.de/artifactory/bytemc-public/"
            )
        )
    }

    override fun load(dependency: Dependency) {
        println("Loading dependency $dependency")
        this.download(dependency)
        this.addToClassPath(Path("dependencies/${dependency.fileName()}"))
    }

    override fun getDependencies(): List<Dependency> {
        return this.loadedDependencies
    }


    private fun download(dependency: Dependency) {
        if (File(dependencyFolder.toFile(), dependency.fileName()).exists()) return

        println("Downloading dependency $dependency")
        if (!dependency.exists()) {
            val url = "$dependency${dependency.artifactId}-${dependency.version}${dependency.getClassifier()}.jar"
            try {
                val connection = ProxyConnection.proxyConnection(url, configuration)
                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val outputStream = FileOutputStream(File("dependencies/${dependency.fileName()}"))
                    val buffer = ByteArray(1024)
                    var bytesRead: Int
                    while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                        outputStream.write(buffer, 0, bytesRead)
                    }
                    outputStream.close()
                    inputStream.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun addToClassPath(path: Path) {
        val classLoader = this.javaClass.classLoader as LauncherUrlClassLoader
        classLoader.addURL(path.toUri().toURL())
    }
}