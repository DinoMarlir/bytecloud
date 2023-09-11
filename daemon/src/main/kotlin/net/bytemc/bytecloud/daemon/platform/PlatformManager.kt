package net.bytemc.bytecloud.daemon.platform

import java.io.File

class PlatformManager {

    private val rootFolder = run {
        val file = File("storage/platforms")

        if (!file.exists()) file.mkdirs()
        file
    }

    val platforms = hashMapOf<String, Platform>(

    )
}