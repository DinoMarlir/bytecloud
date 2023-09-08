package net.bytemc.bytecloud.daemon.configuration

import net.bytemc.bytecloud.daemon.configuration.impl.ProxyConfiguration

class DaemonConfiguration {

    // for connection things
    var proxyConfiguration = ProxyConfiguration(false, "defaultHost",8080);

}