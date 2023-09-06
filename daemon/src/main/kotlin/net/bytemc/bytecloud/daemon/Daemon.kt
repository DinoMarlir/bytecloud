package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.dependencies.DependencyLoaderImpl
import net.bytemc.bytecloud.daemon.logging.LoggerProvider
import net.bytemc.bytecloud.daemon.terminal.JLineTerminal

class Daemon : CloudAPI() {


    private var dependencyLoader = DependencyLoaderImpl()

    var terminal = JLineTerminal()
    var logger = LoggerProvider()

    init {
        instance = this

        logger.info("Starting ByteCloud Daemon...")

        println("polo trest")
    }

    companion object {
        private var instance: Daemon? = null

        fun getInstance(): Daemon {
            return instance!!
        }
    }

    override fun getDependencyLoader(): DependencyLoader {
        return dependencyLoader
    }
}