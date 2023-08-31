package net.bytemc.bytecloud.daemon.database

import net.bytemc.bytecloud.daemon.config.sub.DatabaseConnectionCradinates

interface Database {

    fun getId(): String

    fun connect(cradinates: DatabaseConnectionCradinates)

    fun close()
}