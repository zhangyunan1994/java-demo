package com.abc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
@ChannelHandler.Sharable
public class NettyEchoClientHandler extends ChannelInboundHandlerAdapter {

  public static final NettyEchoClientHandler INSTANCE = new NettyEchoClientHandler();

  private static final Logger logger = LoggerFactory.getLogger(NettyEchoClientHandler.class);

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf in = (ByteBuf) msg;
    int len = in.readableBytes();
    byte[] arr = new byte[len];
    in.getBytes(0, arr);
    logger.info("client received: " + new String(arr, "UTF-8"));
    in.release();
  }
}
