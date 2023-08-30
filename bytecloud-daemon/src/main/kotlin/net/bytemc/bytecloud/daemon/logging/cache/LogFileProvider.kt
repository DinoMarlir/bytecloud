package net.bytemc.bytecloud.daemon.logging.cache

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.nio.file.Files
import java.text.SimpleDateFormat

class LogFileProvider {

    private var dateFormat = SimpleDateFormat("dd-MM-yyyy-HH-mm-ss")
    private var logDirectory = File("logs/")
    private var logFile = File(logDirectory, "latest.log")

    init {
        if (!logDirectory.exists()) {
            logDirectory.mkdirs()
        }

        if(logFile.exists()) {
            Files.move(logFile.toPath(), File(logDirectory, "latest-${dateFormat.format(System.currentTimeMillis())}.log").toPath())
        }
    }

    fun writeLine(line: String) {
        var writer = BufferedWriter(FileWriter(logFile, true))
        writer.write(line)
        writer.newLine()
        writer.close()
    }
}