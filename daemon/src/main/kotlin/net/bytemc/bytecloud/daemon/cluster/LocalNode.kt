package net.bytemc.bytecloud.daemon.cluster

import net.bytemc.bytecloud.api.cluster.Node
import net.bytemc.bytecloud.daemon.network.NettyServer

class LocalNode : Node {

    private var server: NettyServer? = null

    init {
        server = NettyServer()
    }

    override fun close() {
        //todo
    }
}