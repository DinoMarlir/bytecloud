package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.daemon.logging.Logger
import net.bytemc.bytecloud.daemon.terminal.Console
import net.bytemc.bytecloud.daemon.terminal.JLineConsole

class Daemon {

    var console: Console =  JLineConsole()

    init {
        instance = this

        Logger.info("polo ist toll")

    }

    companion object {
        private var instance: Daemon? = null

        @JvmStatic
        fun getInstance(): Daemon {
            return instance!!
        }
    }
}