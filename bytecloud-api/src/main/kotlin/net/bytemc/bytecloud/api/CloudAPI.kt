package net.bytemc.bytecloud.api

import net.bytemc.bytecloud.api.node.Node

abstract class CloudAPI {

    abstract fun getSelfNode(): Node

    init {
        instance = this
    }

    companion object {
        private var instance: CloudAPI? = null

        @JvmStatic
        fun getInstance(): CloudAPI {
            return instance!!
        }
    }

}