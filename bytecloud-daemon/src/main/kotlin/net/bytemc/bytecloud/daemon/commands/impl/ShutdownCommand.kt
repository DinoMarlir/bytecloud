package net.bytemc.bytecloud.daemon.commands.impl

import net.bytemc.bytecloud.daemon.commands.Command
import net.bytemc.bytecloud.daemon.shutdown.DaemonShutdownHandler
import kotlin.system.exitProcess

@Command.Info(name = "shutdown")
class ShutdownCommand : Command {

    override fun execute(args: Array<String>) {
        DaemonShutdownHandler.executeShutdown()
        exitProcess(0)
    }

}