package net.bytemc.bytecloud.daemon.logging

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.logging.cache.LogFileProvider

object Logger {

    private var logProvider = LogFileProvider()

    fun info(message: String) {
        printMessage(LogType.INFO,  message)
    }

    private fun printMessage(logType: LogType, message: String) {
        logProvider.writeLine(message)
        Daemon.getInstance().console.write(logType, message + "\n")
    }
}