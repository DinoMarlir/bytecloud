package net.bytemc.bytecloud.daemon.terminal

import net.bytemc.bytecloud.daemon.logging.LogType

interface Console {

    fun clear()

    fun write(type: LogType, output: String)

    fun prompt(): String

    fun close()

}