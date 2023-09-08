package net.bytemc.bytecloud.api.config

import java.nio.charset.Charset
import java.nio.file.Files
import kotlin.io.path.Path

object ConfigurationProvider {

    fun <T> get(defaultValue: T, pathString: String): T {
        var path = Path("$pathString.json")
        if (!Files.exists(path)) {
            Files.write(
                path,
                ConfigurationLayout.CONFIGURATION_SCHEMA.toJson(defaultValue).toByteArray(Charset.defaultCharset())
            )
            return defaultValue
        }
        return ConfigurationLayout.CONFIGURATION_SCHEMA.fromJson(Files.readString(path), defaultValue!!::class.java)
    }

}