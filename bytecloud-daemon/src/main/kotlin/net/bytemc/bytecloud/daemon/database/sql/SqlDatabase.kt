package net.bytemc.bytecloud.daemon.database.sql

import net.bytemc.bytecloud.api.groups.CloudGroup
import net.bytemc.bytecloud.daemon.database.Database
import java.sql.Connection


abstract class SqlDatabase : Database {

    abstract fun getConnection(): Connection

    fun createTable() {
        this.executeUpdate("CREATE TABLE IF NOT EXISTS bytecloud_groups(id VARCHAR(255) PRIMARY KEY);")
    }

    fun insertGroup(group: CloudGroup) {
        this.executeUpdate("INSERT INTO bytecloud_groups(id) VALUES ('${group.getName()}');")
    }

    fun loadGroups(): List<CloudGroup> {
        //todo
        return mutableListOf()
    }

    private fun executeUpdate(url: String) {
        try {
            this.getConnection().prepareStatement(url).use { preparedStatement -> preparedStatement.executeUpdate() }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}