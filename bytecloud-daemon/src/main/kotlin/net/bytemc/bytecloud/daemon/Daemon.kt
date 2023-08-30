package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.daemon.logging.Logger
import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsole

class Daemon {

    var console: Console =  JLineConsole()

    init {
        instance = this

        Logger.info("Default test message with nothing output.")

    }

    companion object {
        private var instance: Daemon? = null

        @JvmStatic
        fun getInstance(): Daemon {
            return instance!!
        }
    }
}