package net.bytemc.bytecloud.daemon.network

import io.netty5.channel.ChannelHandlerContext
import io.netty5.channel.SimpleChannelInboundHandler

class NettyServerHandler : SimpleChannelInboundHandler<Any>() {

    override fun messageReceived(ctx: ChannelHandlerContext?, msg: Any?) {
        TODO("Not yet implemented")
    }
}