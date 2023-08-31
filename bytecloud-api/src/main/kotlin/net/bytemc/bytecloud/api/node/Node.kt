package net.bytemc.bytecloud.api.node

interface Node {

    fun getId(): String

    fun getHostname(): String

    fun getPort(): Int

}