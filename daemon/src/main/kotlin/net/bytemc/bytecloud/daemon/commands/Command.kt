package net.bytemc.bytecloud.daemon.commands

interface Command {

    fun execute(args: Array<String>)

}