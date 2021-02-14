package com.abc.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Before;
import org.junit.Test;

public class TestWriteLock {
  ReentrantReadWriteLock lock;

  @Before
  public void init() {
    lock = new ReentrantReadWriteLock();
  }

  @Test
  public void lock() {
    lock.readLock().lock();
    lock.readLock().lock();
    lock.writeLock().lock();
  }
}
