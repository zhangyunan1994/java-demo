package com.example.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
    return plusProperties -> {
      DbConfig dbConfig = plusProperties.getGlobalConfig().getDbConfig();
      if (dbConfig == null) {
        dbConfig = new DbConfig();
      }
      dbConfig.setIdType(IdType.AUTO);
      plusProperties.getGlobalConfig().setDbConfig(dbConfig);
    };
  }
}
