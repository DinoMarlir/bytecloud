package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.groups.CloudGroupProvider
import net.bytemc.bytecloud.api.node.Node
import net.bytemc.bytecloud.api.services.CloudServiceProvider
import net.bytemc.bytecloud.daemon.commands.CommandProvider
import net.bytemc.bytecloud.daemon.config.DaemonConfiguration
import net.bytemc.bytecloud.daemon.database.DatabaseProvider
import net.bytemc.bytecloud.daemon.group.CloudGroupProviderImpl
import net.bytemc.bytecloud.daemon.logging.Logger
import net.bytemc.bytecloud.daemon.services.CloudServiceProviderImpl
import net.bytemc.bytecloud.daemon.shutdown.DaemonShutdownHandler
import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsole
import net.bytemc.bytecloud.daemon.terminal.JLineConsoleHelper

class Daemon : CloudAPI() {

    var running = true

    var commandProvider = CommandProvider()
    var console: Console = JLineConsole()
    var databaseProvider = DatabaseProvider()

    private var groupProvider = CloudGroupProviderImpl()
    private var serviceProvider = CloudServiceProviderImpl()

    // main daemon configuration
    private var configuration: DaemonConfiguration? = null


    init {
        instance = this

        Logger.info("Starting ByteCloud Daemon...")

        DaemonShutdownHandler.register()

        // load configuration
        this.configuration = DaemonConfiguration.load()
        this.databaseProvider.initialize(this.configuration!!.database)
    }

    companion object {
        private var instance: Daemon? = null

        @JvmStatic
        fun getInstance(): Daemon {
            return instance!!
        }
    }

    override fun getSelfNode(): Node {
        return this.configuration!!.selfNode
    }

    override fun getGroupProvider(): CloudGroupProvider {
        return this.groupProvider
    }

    override fun getServiceProvider(): CloudServiceProvider {
        return this.serviceProvider
    }
}