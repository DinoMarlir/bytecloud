package net.bytemc.bytecloud.daemon.storage

import java.io.File

class StorageHandler {

    private var path = File("storage/")

    init {
        if (!path.exists()) {
            path.mkdirs()
        }



    }

}