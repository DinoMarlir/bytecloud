package net.bytemc.bytecloud.api.serializer

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.File
import java.io.IOException
import java.nio.file.Path


class PathSerializer : TypeAdapter<Path?>() {

    @Throws(IOException::class)
    override fun write( out: JsonWriter, value: Path?) {
        out.value(value.toString().replace(File.separatorChar, '/'))
    }

    @Throws(IOException::class)
    override fun read(`in`: JsonReader): Path? {
        val path = `in`.nextString()
        return if (path == null) null else Path.of(path)
    }
}