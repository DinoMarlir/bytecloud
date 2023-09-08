package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.config.ConfigurationProvider
import net.bytemc.bytecloud.daemon.configuration.DaemonConfiguration

fun main() {

    // important for proxy configuration
    val configuration = ConfigurationProvider.get(DaemonConfiguration(), "configuration")

    Daemon(configuration)
}