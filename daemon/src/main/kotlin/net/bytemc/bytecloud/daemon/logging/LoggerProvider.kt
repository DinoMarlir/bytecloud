package net.bytemc.bytecloud.daemon.logging

import net.bytemc.bytecloud.daemon.Daemon
import java.io.File
import java.nio.charset.StandardCharsets
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class LoggerProvider : Logger("DaemonLogger", null) {

    private var logDirectory = File("logs/")

    init {
        level = Level.ALL
        useParentHandlers = false

        if(!logDirectory.exists()) {
            logDirectory.mkdirs()
        }

        addHandler(this.initializeFilerHandler())
    }

    override fun info(msg: String?) {
        super.info(msg)
        Daemon.getInstance().terminal.print(msg!!, LogType.INFO)
    }

    private fun initializeFilerHandler() : FileHandler {
        val fileHandler = FileHandler(logDirectory.canonicalPath + "/daemon-log", Integer.MAX_VALUE, 100, false)
        fileHandler.encoding = StandardCharsets.UTF_8.name()
        fileHandler.level = Level.ALL
        fileHandler.formatter = SimpleFormatter()
        return fileHandler
    }
}