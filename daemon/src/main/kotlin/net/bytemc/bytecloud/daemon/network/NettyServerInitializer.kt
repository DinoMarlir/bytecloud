package net.bytemc.bytecloud.daemon.network

import io.netty5.channel.Channel
import io.netty5.channel.ChannelInitializer

class NettyServerInitializer : ChannelInitializer<Channel>() {

    override fun initChannel(ch: Channel) {
        ch.pipeline().addLast("handler", NettyServerHandler())
    }
}