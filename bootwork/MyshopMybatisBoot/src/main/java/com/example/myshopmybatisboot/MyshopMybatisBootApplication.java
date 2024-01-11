package com.example.myshopmybatisboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"myshop.*","naver.storage"})
@MapperScan("myshop.mapper")
@SpringBootApplication
public class MyshopMybatisBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopMybatisBootApplication.class, args);
    }

}
