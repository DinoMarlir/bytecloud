package net.bytemc.bytecloud.api.dependencies

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.nio.file.Path
import kotlin.io.path.Path

class Dependency(private var groupId: String, private var artifactId: String, private var version: String, private var classifier: String) {

    constructor(groupId: String, artifactId: String, version: String) : this(groupId, artifactId, version, "")

    fun download(loader: DependencyLoader) {
        if(!exists()) {
            val baseUrl = "https://repo.maven.apache.org/maven2/${groupId.replace('.', '/')}/$artifactId/$version/"
            val classifierSuffix = if (classifier.isNotEmpty()) "-$classifier" else ""
            val url = "$baseUrl$artifactId-$version$classifierSuffix.jar"


            println(url)
            try {
                val connection = URI(url).toURL().openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val outputStream = FileOutputStream(File("dependencies/$artifactId-$version.jar"))
                    val buffer = ByteArray(1024)
                    var bytesRead: Int
                    while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                        outputStream.write(buffer, 0, bytesRead)
                    }
                    outputStream.close()
                    inputStream.close()
                }
            } catch (e: IOException) {
                println("Ein Fehler ist aufgetreten: ${e.message}")
            }
        } else{
            loader.addToClassPath(Path("dependencies/$artifactId-$version.jar"))
        }
    }

    private fun exists() : Boolean {
        return File("dependencies/$artifactId-$version.jar").exists()
    }
}