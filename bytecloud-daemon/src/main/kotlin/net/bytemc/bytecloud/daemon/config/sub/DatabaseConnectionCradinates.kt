package net.bytemc.bytecloud.daemon.config.sub

open class DatabaseConnectionCradinates(

    val host: String,
    val database: String,
    val username: String,
    val password: String,
    val port: Int,
    val databaseType: String

)
