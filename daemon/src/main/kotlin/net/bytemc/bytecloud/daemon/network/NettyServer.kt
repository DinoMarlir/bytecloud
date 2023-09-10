package net.bytemc.bytecloud.daemon.network

import io.netty5.bootstrap.ServerBootstrap
import io.netty5.channel.Channel
import io.netty5.channel.MultithreadEventLoopGroup
import io.netty5.channel.epoll.Epoll
import io.netty5.channel.epoll.EpollHandler
import io.netty5.channel.epoll.EpollServerSocketChannel
import io.netty5.channel.nio.NioHandler
import io.netty5.channel.socket.nio.NioServerSocketChannel
import net.bytemc.bytecloud.daemon.Daemon

class NettyServer {

    private val bossGroup =
        MultithreadEventLoopGroup(if (Epoll.isAvailable()) EpollHandler.newFactory() else NioHandler.newFactory())
    private val workerGroup =
        MultithreadEventLoopGroup(if (Epoll.isAvailable()) EpollHandler.newFactory() else NioHandler.newFactory())

    private val channel: Channel? = null

    init {
        ServerBootstrap()
            .group(bossGroup, workerGroup)
            .channel(if (Epoll.isAvailable()) EpollServerSocketChannel::class.java else NioServerSocketChannel::class.java)
            .childHandler(NettyServerInitializer())
            .bind("127.0.0.1", 9987)
            .addListener {
                Daemon.getInstance().logger.info("Netty server started")
            }
    }

    fun close() {

    }

}