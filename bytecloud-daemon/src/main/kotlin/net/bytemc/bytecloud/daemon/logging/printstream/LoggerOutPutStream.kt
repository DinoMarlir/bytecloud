package net.bytemc.bytecloud.daemon.logging.printstream

import net.bytemc.bytecloud.daemon.Daemon
import net.bytemc.bytecloud.daemon.logging.Logger
import java.io.OutputStream
import java.io.PrintStream

class LoggerOutPutStream(out: OutputStream) : PrintStream(out) {

    override fun println(x: Any?) {
        this.println(x.toString())
    }

    override fun println(message: String) {
        Logger.info(message)
    }
}