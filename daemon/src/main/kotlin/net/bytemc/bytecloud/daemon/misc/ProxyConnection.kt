package net.bytemc.bytecloud.daemon.misc

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.configuration.impl.ProxyConfiguration
import java.net.*


object ProxyConnection {

    fun proxyConnection(url: String, configuration: ProxyConfiguration): HttpURLConnection {
        val url = URI(url).toURL();

        var connection: URLConnection
        if (configuration.use) {
            val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(configuration.hostname, configuration.port))
            connection = url.openConnection(proxy) as HttpURLConnection
        } else {
            connection = url.openConnection() as HttpURLConnection
        }
        connection.requestMethod = "GET"
        return connection
    }
}