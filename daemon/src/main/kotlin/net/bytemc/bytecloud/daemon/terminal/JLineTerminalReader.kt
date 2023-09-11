package net.bytemc.bytecloud.daemon.terminal

import net.bytemc.bytecloud.daemon.terminal.utils.Color
import org.jline.reader.LineReader
import org.jline.reader.UserInterruptException
import kotlin.system.exitProcess

class JLineTerminalReader(private var reader: LineReader) : Thread("terminal-reader") {

    var prompt = Color.translate("&fcloud &8» &7")

    override fun run() {
        try {
            while (!isInterrupted) {
                var line = reader.readLine(this.prompt)

                JLineConsoleHelper.resetLine(1)
            }
        } catch (ignore: UserInterruptException) {
            exitProcess(0)
        }
    }
}