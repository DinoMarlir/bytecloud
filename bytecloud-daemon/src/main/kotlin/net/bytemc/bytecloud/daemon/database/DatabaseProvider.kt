package net.bytemc.bytecloud.daemon.database

import net.bytemc.bytecloud.daemon.config.sub.DatabaseConnectionCradinates
import net.bytemc.bytecloud.daemon.database.h2.H2Database
import net.bytemc.bytecloud.daemon.logging.Logger

class DatabaseProvider {

    var currentDatabase: Database? = null
    private val databases = listOf(H2Database())

    fun initialize(cradinates: DatabaseConnectionCradinates) {
        val database = getDatabase(cradinates.databaseType)
        this.currentDatabase = database;
        database.connect(cradinates)
        Logger.info("Connected to database ${database.getId()}")
    }

    private fun getDatabase(id: String): Database {
        return databases.firstOrNull { it.getId() == id } ?: throw IllegalArgumentException("Database $id not found")
    }
}