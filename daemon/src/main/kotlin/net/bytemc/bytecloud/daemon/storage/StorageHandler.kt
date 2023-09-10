package net.bytemc.bytecloud.daemon.storage

import java.io.File

class StorageHandler {

    private val filePath = File("storage")

    init {
        if(!filePath.exists()) {
            filePath.mkdirs()
        }
    }

}