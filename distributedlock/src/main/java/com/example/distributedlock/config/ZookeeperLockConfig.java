package com.example.distributedlock.config;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.config.CuratorFrameworkFactoryBean;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

@Configuration
public class ZookeeperLockConfig {

  @Value("${zookeeper.host}")
  private String zkUrl;

  @Bean
  public CuratorFrameworkFactoryBean curatorFrameworkFactoryBean() {
    return new CuratorFrameworkFactoryBean(zkUrl);
  }

  @Bean
  public ZookeeperLockRegistry zookeeperLockRegistry(CuratorFramework curatorFramework) {
    return new ZookeeperLockRegistry(curatorFramework, "/lock");
  }
}
