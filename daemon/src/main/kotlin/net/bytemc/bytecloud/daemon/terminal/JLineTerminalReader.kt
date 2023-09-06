package net.bytemc.bytecloud.daemon.terminal

import org.jline.reader.LineReader
import org.jline.reader.UserInterruptException

class JLineTerminalReader(private var reader: LineReader) : Thread("terminal-reader") {

    override fun run() {
        try {
            while (!isInterrupted) {
                var line = reader.readLine("cloud » ")

            }
        } catch (ignore: UserInterruptException) { }
    }
}