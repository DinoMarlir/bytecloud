package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.daemon.logging.printstream.LoggerOutPutStream

fun main() {

    System.setOut(LoggerOutPutStream(System.out))

    Daemon()

}