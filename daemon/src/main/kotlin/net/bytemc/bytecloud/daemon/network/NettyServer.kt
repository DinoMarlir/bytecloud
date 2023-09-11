package net.bytemc.bytecloud.daemon.network

import io.netty5.bootstrap.ServerBootstrap
import io.netty5.channel.Channel
import io.netty5.channel.ChannelOption
import io.netty5.channel.IoHandlerFactory
import io.netty5.channel.MultithreadEventLoopGroup
import io.netty5.channel.ServerChannel
import io.netty5.channel.ServerChannelFactory
import io.netty5.channel.epoll.Epoll
import io.netty5.channel.epoll.EpollHandler
import io.netty5.channel.epoll.EpollServerSocketChannel
import io.netty5.channel.nio.NioHandler
import io.netty5.channel.socket.nio.NioServerSocketChannel
import net.bytemc.bytecloud.daemon.Daemon

class NettyServer {

    private val bossGroup = createEventLoopGroup(1)
    private val workerGroup = createEventLoopGroup(0)

    init {
        ServerBootstrap()
            .group(bossGroup, workerGroup)
            .channelFactory(::NioServerSocketChannel)
            .childHandler(NettyServerInitializer())

            // properties
            .option(ChannelOption.AUTO_READ, true)
            .option(ChannelOption.SO_REUSEADDR, true)

            .childOption(ChannelOption.TCP_NODELAY, true)
            .childOption(ChannelOption.SO_KEEPALIVE, true)

            .bind("127.0.0.1", 9987)
            .addListener {
                Daemon.getInstance().logger.info("Netty server started")
            }
    }

    fun close() {
        bossGroup.shutdownGracefully()
        workerGroup.shutdownGracefully()
    }

    private fun createEventLoopGroup(threads: Int): MultithreadEventLoopGroup {
        if (Epoll.isAvailable()) {
            return MultithreadEventLoopGroup(threads, EpollHandler.newFactory())
        }
        return MultithreadEventLoopGroup(threads, NioHandler.newFactory())
    }
}