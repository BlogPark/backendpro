package com.yongming.backendpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan({"com.yongming.backendpro.*.mapper"})
@Configuration
public class BackendproApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendproApplication.class, args);
    }

}
