package net.bytemc.bytecloud.daemon.config

import net.bytemc.bytecloud.daemon.config.sub.DatabaseConnectionCradinates
import net.bytemc.bytecloud.daemon.node.NodeImpl
import kotlin.io.path.Path

class DaemonConfiguration {

    var selfNode = NodeImpl("daemon-1", "127.0.0.1", 8876)

    var database = DatabaseConnectionCradinates(
        "localhost",
        "cloud",
        "USERNAME",
        "PASSWORD",
        -1,
        "H2"
    )

    companion object {
        fun load(): DaemonConfiguration {
            return ConfigurationProvider.readConfiguration(Path("config.json"), DaemonConfiguration())
        }
    }
}