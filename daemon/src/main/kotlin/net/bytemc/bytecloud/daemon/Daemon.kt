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

        logger.info("polo")

    }

    override fun getDependencyLoader(): DependencyLoader {
        return dependencyLoader
    }
}