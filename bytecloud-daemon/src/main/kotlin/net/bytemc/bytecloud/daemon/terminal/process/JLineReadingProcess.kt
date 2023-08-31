package net.bytemc.bytecloud.daemon.terminal.process

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsoleHelper
import org.jline.reader.LineReader
import org.jline.reader.UserInterruptException
import java.util.*
import kotlin.system.exitProcess

class JLineReadingProcess(private var console: Console, private var reader: LineReader) :
    Thread("bytecloud-daemon-console") {

    override fun run() {
        try {
            while (!isInterrupted) {
                val line = reader.readLine(console.prompt())
                val args = line.split(" ").toTypedArray()
                JLineConsoleHelper.resetLine(1)

                // todo check setup

                Daemon.getInstance().commandProvider.call(args[0], Arrays.copyOfRange(args, 1, args.size))
            }
        } catch (ex: UserInterruptException) { }
    }
}