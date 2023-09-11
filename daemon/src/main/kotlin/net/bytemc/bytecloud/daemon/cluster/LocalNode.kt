package net.bytemc.bytecloud.daemon.cluster

import net.bytemc.bytecloud.api.cluster.Node
import net.bytemc.bytecloud.daemon.network.NettyServer

class LocalNode : Node {

    private var server: NettyServer = NettyServer()

    override fun close() {
        this.server.close()
    }
}