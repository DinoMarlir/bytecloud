package net.bytemc.bytecloud.daemon.terminal

interface Console {

    fun clear()

    fun write(output: String)

    fun prompt(): String

}