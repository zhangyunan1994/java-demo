package com.abc.lock;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TestLock {

  void aa() {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    new HashMap<>();
  }


}
