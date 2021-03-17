package com.abc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * create by 尼恩 @ 疯狂创客圈
 **/
@ChannelHandler.Sharable
public class NettyEchoServerHandler extends ChannelInboundHandlerAdapter {

  public static final NettyEchoServerHandler INSTANCE = new NettyEchoServerHandler();

  private static final Logger logger = LoggerFactory.getLogger(NettyEchoServerHandler.class);

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf in = (ByteBuf) msg;
    int len = in.readableBytes();
    byte[] arr = new byte[len];
    in.getBytes(0, arr);

    logger.info("server received: " + new String(arr, StandardCharsets.UTF_8));
    ChannelFuture f = ctx.writeAndFlush(msg);
  }
}
