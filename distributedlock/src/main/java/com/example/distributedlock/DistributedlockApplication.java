package com.example.distributedlock;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedlockApplication {

  public static void main(String[] args) {
    InterProcessMutex mutex = new InterProcessMutex(null, "keys");
    SpringApplication.run(DistributedlockApplication.class, args);
  }

}
