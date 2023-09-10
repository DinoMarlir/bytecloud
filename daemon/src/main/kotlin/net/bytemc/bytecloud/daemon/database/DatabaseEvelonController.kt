package net.bytemc.bytecloud.daemon.database

import net.bytemc.bytecloud.daemon.configuration.impl.DatabaseConfiguration
import net.bytemc.evelon.DatabaseProtocol
import net.bytemc.evelon.Evelon
import net.bytemc.evelon.cradinates.DatabaseCradinates
import net.bytemc.evelon.h2.H2Connection
import kotlin.io.path.Path

class DatabaseEvelonController(databaseConfiguration: DatabaseConfiguration) {

    init {
        val cradinates = DatabaseCradinates(
            DatabaseProtocol.valueOf(databaseConfiguration.databaseProtocol),
            databaseConfiguration.hostname,
            databaseConfiguration.password,
            databaseConfiguration.user,
            databaseConfiguration.database,
            databaseConfiguration.port
        )

        if (cradinates.databaseProtocol == DatabaseProtocol.H2) {
            H2Connection.setPath(Path("storage/h2database"))
        }

        // initialize evelon with cloud configuration
        Evelon.setDatabaseCradinates(cradinates)
    }
}