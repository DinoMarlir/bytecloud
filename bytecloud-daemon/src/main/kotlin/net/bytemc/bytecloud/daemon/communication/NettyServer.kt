package net.bytemc.bytecloud.daemon.communication

import io.netty5.bootstrap.ServerBootstrap
import io.netty5.channel.MultithreadEventLoopGroup
import io.netty5.channel.epoll.Epoll
import io.netty5.channel.epoll.EpollServerSocketChannel
import io.netty5.channel.socket.nio.NioServerSocketChannel
import net.bytemc.bytecloud.api.node.Node

class NettyServer {

    private var bossGroup = MultithreadEventLoopGroup(NettyUtils.getFactory())
    private var workerGroup = MultithreadEventLoopGroup(NettyUtils.getFactory())

    fun connect(node: Node) {
        ServerBootstrap()
            .channelFactory { bossEventLoop, workerEventLoopGroup ->
                if (Epoll.isAvailable()) {
                    EpollServerSocketChannel(bossEventLoop, workerEventLoopGroup)
                } else {
                    NioServerSocketChannel(bossEventLoop, workerEventLoopGroup)
                }
            }
            .group(bossGroup, workerGroup)
            .bind(node.getHostname(), node.getPort())
            .addListener {
                if (it.isSuccess) {

                }
            }
    }

}