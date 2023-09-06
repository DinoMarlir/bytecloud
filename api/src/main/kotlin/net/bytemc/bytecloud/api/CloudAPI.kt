package net.bytemc.bytecloud.api

import net.bytemc.bytecloud.api.dependencies.DependencyLoader

abstract class CloudAPI {

    init {
        instance = this
    }

    abstract fun getDependencyLoader() : DependencyLoader

    companion object {

        private var instance: CloudAPI? = null

        fun getInstance(): CloudAPI {
            return instance!!
        }
    }
}