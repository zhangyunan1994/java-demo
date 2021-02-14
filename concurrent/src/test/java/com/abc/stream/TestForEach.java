package com.abc.stream;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;

public class TestForEach {

  List<Integer> dataList;

  @Before
  public void init() {
    dataList = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
  }

  @Test
  public void testFor() throws InterruptedException {
    for (Integer integer : dataList) {
      ff();
    }
  }

  @Test
  public void testForEach() {
    dataList.forEach(it -> {
      ff();
    });
  }

  @Test
  public void testStreamForEach() {
    dataList.stream().forEach(it -> {
      ff();
    });
  }

  @Test
  public void testParallelStreamForEach() {
    dataList.parallelStream().map();
  }


  public void ff() {
    try {
      Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
