package net.bytemc.bytecloud.api.dependencies

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.nio.file.Path
import kotlin.io.path.Path

class Dependency(private var groupId: String, var artifactId: String, var version: String, var classifier: String) {

    constructor(groupId: String, artifactId: String, version: String) : this(groupId, artifactId, version, "")

    fun exists() : Boolean {
        return File("dependencies/$artifactId-$version.jar").exists()
    }

    override fun toString(): String {
        return "https://repo.maven.apache.org/maven2/${groupId.replace('.', '/')}/${artifactId}/${version}/"
    }

    fun fileName(): String {
        return "$artifactId-$version.jar"
    }

}