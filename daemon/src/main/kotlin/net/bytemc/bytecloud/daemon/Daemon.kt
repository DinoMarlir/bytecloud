package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.dependencies.DependencyLoaderImpl
import net.bytemc.bytecloud.daemon.logging.LoggerProvider

class Daemon : CloudAPI() {

    private var dependencyLoader = DependencyLoaderImpl()

    var logger = LoggerProvider()

    init {

        logger.info("polo")

    }

    override fun getDependencyLoader(): DependencyLoader {
        return dependencyLoader
    }
}