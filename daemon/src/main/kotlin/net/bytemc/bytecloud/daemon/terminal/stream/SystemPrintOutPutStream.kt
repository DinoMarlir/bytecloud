package net.bytemc.bytecloud.daemon.terminal.stream

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.logging.LogType
import java.io.PrintStream

class SystemPrintOutPutStream : PrintStream(System.out) {

    override fun println(x: Any) {
        super.println(x)

        Daemon.getInstance().logger.info(x.toString())
        Daemon.getInstance().terminal.write(x.toString())
    }

    override fun println(x: String) {
        super.println(x)

        Daemon.getInstance().logger.info(x)
        Daemon.getInstance().terminal.write(x)
    }
}