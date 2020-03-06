package com.yongming.backendpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendproApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendproApplication.class, args);
  }
}
