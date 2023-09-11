package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.cluster.Node
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.cluster.LocalNode
import net.bytemc.bytecloud.daemon.configuration.DaemonConfiguration
import net.bytemc.bytecloud.daemon.database.DatabaseEvelonController
import net.bytemc.bytecloud.daemon.dependencies.DependencyLoaderImpl
import net.bytemc.bytecloud.daemon.logging.LoggerProvider
import net.bytemc.bytecloud.daemon.shutdown.DaemonShutdownHandler
import net.bytemc.bytecloud.daemon.storage.StorageHandler
import net.bytemc.bytecloud.daemon.terminal.JLineTerminal

class Daemon(private var configuration: DaemonConfiguration) : CloudAPI() {

    private var dependencyLoader = DependencyLoaderImpl(this.configuration.proxyConfiguration)

    var selfNode : Node

    var terminal = JLineTerminal()
    var logger = LoggerProvider()
    var storageHandle = StorageHandler()

    init {
        instance = this

        logger.info("Starting ByteCloud Daemon...")

        // load database
        DatabaseEvelonController(this.configuration.databaseConfiguration)

        DaemonShutdownHandler.register()

        selfNode = LocalNode()
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