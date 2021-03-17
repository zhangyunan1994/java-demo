package com.abc;

import java.util.LinkedList;
import java.util.Timer;

public class QueueWithTimeOut {

  private LinkedList<Node> que;
  private Timer timer;
  private int size;
  private int curSize = 0;

  QueueWithTimeOut(int size, int delay, int interval) {
    this.size = size;
    this.que = new LinkedList();
    this.timer = new Timer();

    //使用Timer
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                scanAndDelete();
//            }
//        }, delay, interval);

    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(delay);
      } catch (Exception e) {
        e.printStackTrace();
      }
      while (true) {
        try {
          scanAndDelete();
          Thread.sleep(interval);//注意此处要用类去调用静态方法，直接用实例thread调用会报其可能尚未实例化
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }, "scanThread");
    thread.start();
  }

  public class Node {

    Object key;
    long timeout; //这里timeout存放的是currentTime + timeout

    Node(Object key, long timeout) {
      this.key = key;
      this.timeout = timeout;
    }

    public long getTimeout() {
      return timeout;
    }
  }

  public synchronized void offer(Object key, long currentTime, long timeout) throws Exception {
    timeout += currentTime;
    if (curSize > size) {
      throw new Exception("size 已满");
    }
    Node node = new Node(key, timeout);
    que.offer(node);
    curSize++;
  }

  public synchronized Object poll() {
    if (!que.isEmpty()) {
      return que.poll();
    } else {
      return null;
    }
  }

  private synchronized void scanAndDelete() {
    if (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        if (que.get(i).getTimeout() < getCurrentTime()) {
          que.remove(i);
        }
      }
    } else {
      return;
    }
  }

  private long getCurrentTime() {
    return System.currentTimeMillis();
  }
}

