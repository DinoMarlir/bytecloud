package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.dependencies.DependencyLoaderImpl
import net.bytemc.bytecloud.daemon.logging.LoggerProvider
import net.bytemc.bytecloud.daemon.terminal.JLineTerminal

class Daemon : CloudAPI() {

    var terminal = JLineTerminal()
    var logger = LoggerProvider()

    private var dependencyLoader = DependencyLoaderImpl()

    init {
        instance = this

        logger.info("Starting ByteCloud Daemon...")

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