package net.bytemc.bytecloud.daemon.commands

import net.bytemc.bytecloud.daemon.commands.impl.ShutdownCommand

class CommandProvider {

    private val commands = HashMap<String, Command>()

    init {
        this.registerCommand(ShutdownCommand())
    }

    fun call(name: String, args: Array<String>) {
        val command = commands[name] ?: return
        //todo args
        command.execute(args)
    }

    private fun registerCommand(command: Command) {
        commands[command.info().name] = command
    }
}