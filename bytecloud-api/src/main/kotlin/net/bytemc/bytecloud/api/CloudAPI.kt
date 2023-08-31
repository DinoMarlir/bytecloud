package net.bytemc.bytecloud.api

import net.bytemc.bytecloud.api.groups.CloudGroupProvider
import net.bytemc.bytecloud.api.node.Node
import net.bytemc.bytecloud.api.services.CloudServiceProvider

abstract class CloudAPI {

    abstract fun getSelfNode(): Node

    abstract fun getGroupProvider(): CloudGroupProvider

    abstract fun getServiceProvider(): CloudServiceProvider

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