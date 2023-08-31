package net.bytemc.bytecloud.daemon.node

import net.bytemc.bytecloud.api.node.Node

class NodeImpl(private var id: String, private var hostname: String, private var port: Int) : Node {

    override fun getId(): String {
        return id
    }

    override fun getHostname(): String {
        return hostname
    }

    override fun getPort(): Int {
        return port
    }
}