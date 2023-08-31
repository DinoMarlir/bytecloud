package net.bytemc.bytecloud.daemon.shutdown

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.logging.Logger
import net.bytemc.bytecloud.daemon.terminal.JLineConsoleHelper

object DaemonShutdownHandler {

    fun register() {
        var thread = Thread { executeShutdown() }
        thread.isDaemon = false
        thread.name = "bytecloud-daemon-shutdown"
        Runtime.getRuntime().addShutdownHook(thread)
    }

    private fun executeShutdown() {

        Logger.info("Shutting down daemon...")

        Logger.info("Closing database connection...")
        Daemon.getInstance().databaseProvider.currentDatabase?.close()
        JLineConsoleHelper.updateLine(1, "Closed database connection")

        Logger.info("Closing console...")
        Daemon.getInstance().console.close()
        Logger.info("Succerssfully shutdown daemon")
        Thread.sleep(300)
    }

}