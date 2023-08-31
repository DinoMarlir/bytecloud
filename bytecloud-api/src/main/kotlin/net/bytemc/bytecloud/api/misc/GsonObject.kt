package net.bytemc.bytecloud.api.misc

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.bytemc.bytecloud.api.serializer.PathSerializer
import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Path


object GsonObject {

    private val DEFAULT_GSON: Gson = GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .registerTypeHierarchyAdapter(Path::class.java, PathSerializer())
        .disableHtmlEscaping()
        .create()

    val SENDABLE_GSON: Gson = GsonBuilder()
        .serializeNulls()
        .registerTypeHierarchyAdapter(Path::class.java, PathSerializer())
        .disableHtmlEscaping()
        .create()

    fun write(path: Path, value: Any?) {
        try {
            FileWriter(path.toFile()).use { writer -> writer.write(DEFAULT_GSON.toJson(value)) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun <T> read(path: Path, value: Class<T>?): T? {
        try {
            BufferedReader(FileReader(path.toFile())).use { reader -> return DEFAULT_GSON.fromJson(reader, value) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

}