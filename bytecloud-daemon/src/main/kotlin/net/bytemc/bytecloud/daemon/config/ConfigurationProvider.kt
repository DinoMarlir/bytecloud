package net.bytemc.bytecloud.daemon.config

import net.bytemc.bytecloud.api.misc.GsonObject
import java.nio.file.Files
import java.nio.file.Path

object ConfigurationProvider {

    private fun createConfigurationIfNotExists(path: Path, value: Any?) {
        if (!Files.exists(path)) {
            GsonObject.write(path, value)
        }
    }

    fun <T> readConfiguration(path: Path, value: T): T {
        createConfigurationIfNotExists(path, value)
        return GsonObject.read(path, value!!::class.java)!!
    }

}