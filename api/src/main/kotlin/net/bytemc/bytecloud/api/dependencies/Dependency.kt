package net.bytemc.bytecloud.api.dependencies

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class Dependency(var groupId: String, var artifactId: String, var version: String) {

    fun download() {
        val url = "https://repo.maven.apache.org/maven2/${groupId.replace('.', '/')}/$artifactId/$version/$artifactId-$version.jar"

        try {
            val connection = URL(url).openConnection() as HttpURLConnection
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
    }

    fun exists() {

    }

}