package com.abc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

public class StickyBagDecoderTest {

  @Test
  public void testByteToIntegerDecoder() {
    ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
      protected void initChannel(EmbeddedChannel ch) {
        ch.pipeline().addLast(NettyEchoServerHandler.INSTANCE);
      }
    };
    EmbeddedChannel channel = new EmbeddedChannel(channelInitializer);

    byte[] bytes = "疯狂创客圈：高性能学习社群!".getBytes(StandardCharsets.UTF_8);
    for (int i = 0; i < 1000; i++) {
      //发送ByteBuf
      ByteBuf buffer = channel.alloc().buffer();
      buffer.writeBytes(bytes);
      channel.writeInbound(buffer);
    }
    try {
      Thread.sleep(Integer.MAX_VALUE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
