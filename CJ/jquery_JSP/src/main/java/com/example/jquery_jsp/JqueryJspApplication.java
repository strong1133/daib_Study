package com.example.jquery_jsp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan(basePackages = "com.example.jquery_jsp")
public class JqueryJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(JqueryJspApplication.class, args);
    }

}
