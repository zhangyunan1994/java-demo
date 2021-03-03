package com.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisplus.config")
public class MybatisplusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisplusApplication.class, args);
  }

}
