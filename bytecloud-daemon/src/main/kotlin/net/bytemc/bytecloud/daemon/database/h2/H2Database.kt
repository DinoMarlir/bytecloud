package net.bytemc.bytecloud.daemon.database.h2

import net.bytemc.bytecloud.daemon.config.sub.DatabaseConnectionCradinates
import net.bytemc.bytecloud.daemon.database.sql.SqlDatabase
import java.nio.file.Path
import java.sql.Connection
import java.sql.DriverManager

class H2Database : SqlDatabase() {

    private val h2DatabaseFile = Path.of("storage", "database.h2")
    private var connection: Connection? = null

    init {
        Class.forName("org.h2.Driver")
    }

    override fun getId() : String {
        return "H2"
    }

    override fun connect(cradinates: DatabaseConnectionCradinates) {
        this.connection = DriverManager.getConnection("jdbc:h2:" + this.h2DatabaseFile.toAbsolutePath());
    }
}