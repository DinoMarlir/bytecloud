package net.bytemc.bytecloud.daemon.database.sql

import net.bytemc.bytecloud.daemon.database.Database
import java.sql.Connection


abstract class SqlDatabase : Database {

    init {
        this.executeUpdate("CREATE TABLE IF NOT EXISTS bytecloud_groups(id VARCHAR(255) PRIMARY KEY);")
    }

    abstract fun getConnection() : Connection

    fun executeUpdate(url: String) {
        try {
            this.getConnection().prepareStatement(url).use { preparedStatement -> preparedStatement.executeUpdate() }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}