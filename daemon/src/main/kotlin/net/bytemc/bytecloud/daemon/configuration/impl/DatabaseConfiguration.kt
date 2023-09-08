package net.bytemc.bytecloud.daemon.configuration.impl

import net.bytemc.evelon.DatabaseProtocol

class DatabaseConfiguration(
    var databaseProtocol: String,
    var hostname: String,
    var password: String,
    var user: String,
    var database: String,
    var port: Int
) {

}