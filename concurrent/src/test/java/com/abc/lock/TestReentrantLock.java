package com.abc.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Before;
import org.junit.Test;

public class TestReentrantLock {

  Lock lock;

  @Before
  public void init() {
    lock = new ReentrantLock();
  }

  @Test
  public void lock() throws InterruptedException {
    Runnable r1 = () -> {
      lock.lock();
      try {
        System.out.println("r1 lock ");
        System.out.println(new Date());
        Thread.sleep(TimeUnit.SECONDS.toMillis(4));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      lock.unlock();
    };

    Runnable r2 = () -> {
      lock.lock();
      try {
        System.out.println("r2 lock");
        System.out.println(new Date());
        Thread.sleep(TimeUnit.SECONDS.toMillis(4));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      lock.unlock();
    };
    new Thread(r2).start();
    new Thread(r1).start();
    Thread.sleep(TimeUnit.SECONDS.toMillis(10));
  }

}
