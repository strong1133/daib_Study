package com.study.jspexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan(basePackages = "com.study.jspexcel")
public class JspExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspExcelApplication.class, args);
    }

}
