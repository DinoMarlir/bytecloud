package net.bytemc.bytecloud.daemon.terminal.process

import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsoleHelper
import org.jline.reader.LineReader

class JLineReadingProcess(private var console: Console, private var reader : LineReader) : Thread("bytecloud-daemon-console") {

    override fun run() {
        while (!isInterrupted) {
            val line = reader.readLine(console.prompt())

            JLineConsoleHelper.resetLine(1)

            // todo check setup

            // todo check command

        }
    }
}