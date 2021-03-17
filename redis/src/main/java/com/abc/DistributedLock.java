package com.abc;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

public class DistributedLock implements Lock {

  private static JedisPool JEDIS_POOL = null;
  private static int EXPIRE_SECONDS = 60;

  public static void setJedisPool(JedisPool jedisPool, int expireSecond) {
    JEDIS_POOL = jedisPool;
    EXPIRE_SECONDS = expireSecond;
  }

  private String lockKey;
  private String lockValue;

  private DistributedLock(String lockKey) {
    this.lockKey = lockKey;
  }

  public static DistributedLock newLock(String lockKey) {
    return new DistributedLock(lockKey);
  }

  @Override
  public void lock() {
    if (!tryLock()) {
      throw new IllegalStateException("未获取到锁");
    }
  }

  @Override
  public void lockInterruptibly() throws InterruptedException {
  }

  @Override
  public boolean tryLock() {
    return tryLock(0, null);
  }

  @Override
  public boolean tryLock(long time, TimeUnit unit) {
    Jedis conn = null;
    String retIdentifier = null;
    try {
      conn = JEDIS_POOL.getResource();
      lockKey = UUID.randomUUID().toString();

      // 获取锁的超时时间，超过这个时间则放弃获取锁
      long end = 0;
      if (time != 0) {
        end = System.currentTimeMillis() + unit.toMillis(time);
      }

      do {
        if (conn.setnx(lockKey, lockValue) == 1) {
          conn.expire(lockKey, EXPIRE_SECONDS);
          return true;
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      } while (System.currentTimeMillis() < end);
    } catch (JedisException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.close();
      }
    }
    return false;
  }

  @Override
  public void unlock() {
    Jedis conn = null;
    try {
      conn = JEDIS_POOL.getResource();
      if (lockValue.equals(conn.get(lockKey))) {
        conn.del(lockKey);
      }
    } catch (JedisException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.close();
      }
    }
  }

  @Override
  public Condition newCondition() {
    return null;
  }
}
