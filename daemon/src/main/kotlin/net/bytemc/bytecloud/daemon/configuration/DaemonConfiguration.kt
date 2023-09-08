package net.bytemc.bytecloud.daemon.configuration

import net.bytemc.bytecloud.daemon.configuration.impl.DatabaseConfiguration
import net.bytemc.bytecloud.daemon.configuration.impl.ProxyConfiguration
import net.bytemc.evelon.DatabaseProtocol
import net.bytemc.evelon.cradinates.DatabaseCradinates

class DaemonConfiguration {

    // for connection things
    var proxyConfiguration = ProxyConfiguration(false, "defaultHost",8080);

    // we cant use cradinates, because he need evelon dependency on first startup
    var databaseConfiguration = DatabaseConfiguration("H2", "HOSTNAME", "PASSWORD", "USERNAME", "cloud", -1);

}