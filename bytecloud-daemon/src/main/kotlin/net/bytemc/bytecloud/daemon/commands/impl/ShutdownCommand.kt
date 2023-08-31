package net.bytemc.bytecloud.daemon.commands.impl

import net.bytemc.bytecloud.daemon.commands.Command
import kotlin.system.exitProcess

@Command.Info(name = "shutdown")
class ShutdownCommand : Command {

    override fun execute(args: Array<String>) {
        exitProcess(0)
    }
}