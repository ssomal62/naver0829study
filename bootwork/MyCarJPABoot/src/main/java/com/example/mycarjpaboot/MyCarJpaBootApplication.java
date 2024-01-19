package com.example.mycarjpaboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"naver.storage","person.*", "guest.*", "mycar.*"})
@EntityScan("*.data")
@EnableJpaRepositories({"person.data", "guest.data", "mycar.*"})
public class MyCarJpaBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCarJpaBootApplication.class, args);
    }

}
