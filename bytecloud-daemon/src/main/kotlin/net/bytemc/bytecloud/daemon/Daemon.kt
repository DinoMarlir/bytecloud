package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.node.Node
import net.bytemc.bytecloud.daemon.config.DaemonConfiguration
import net.bytemc.bytecloud.daemon.database.DatabaseProvider
import net.bytemc.bytecloud.daemon.logging.Logger
import net.bytemc.bytecloud.daemon.shutdown.DaemonShutdownHandler
import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsole

class Daemon : CloudAPI() {

    var console: Console = JLineConsole()
    private var databaseProvider = DatabaseProvider()

    // main daemon configuration
    private var configuration: DaemonConfiguration? = null


    init {
        instance = this

        Runtime.getRuntime().addShutdownHook(Thread { DaemonShutdownHandler.executeShutdown() })

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
}