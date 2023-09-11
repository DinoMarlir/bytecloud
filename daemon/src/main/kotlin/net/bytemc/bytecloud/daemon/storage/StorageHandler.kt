package net.bytemc.bytecloud.daemon.storage

import java.io.File

class StorageHandler {

    private val filePath = run {
        val file = File("storage")

        if (!file.exists()) file.mkdirs()
        file
    }
}