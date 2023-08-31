package net.bytemc.bytecloud.daemon.communication

import io.netty5.channel.EventLoopGroup
import io.netty5.channel.IoHandlerFactory
import io.netty5.channel.epoll.Epoll
import io.netty5.channel.epoll.EpollHandler
import io.netty5.channel.nio.NioHandler

object NettyUtils {

    fun getFactory(): IoHandlerFactory {
        return if (Epoll.isAvailable()) EpollHandler.newFactory() else NioHandler.newFactory()
    }

}