package net.bytemc.bytecloud.daemon.shutdown

import net.bytemc.bytecloud.daemon.Daemon

object DaemonShutdownHandler {

    fun register() {
        Runtime.getRuntime().addShutdownHook(Thread {

            //todo clear queue

            //todo delete temp folder

            Daemon.getInstance().selfNode.close()


        })
    }

}